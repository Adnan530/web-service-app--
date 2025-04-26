package wsdl.controller;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import wsdl.schema.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Endpoint
public class EmployeeEndPoint {

    private static final String NAMESPACE_URI = "http://example.com/employee";

    // Simulated in-memory database
    private static final Map<Long, Employee> employeeDB = new HashMap<>();
    private static long idCounter = 1;

    // ========= Create Employee =========
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createEmployeeRequest")
    @ResponsePayload
    public CreateEmployeeResponse createEmployee(@RequestPayload CreateEmployeeRequest request) {
        Employee employee = request.getEmployee();
        employee.setId(idCounter++); // auto-generate ID
        employeeDB.put(employee.getId(), employee);

        CreateEmployeeResponse response = new CreateEmployeeResponse();
        response.setEmployee(employee);
        return response;
    }

    // ========= Update Employee =========
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateEmployeeRequest")
    @ResponsePayload
    public UpdateEmployeeResponse updateEmployee(@RequestPayload UpdateEmployeeRequest request) {
        Employee updatedEmployee = request.getEmployee();
        employeeDB.put(updatedEmployee.getId(), updatedEmployee); // simple replace

        UpdateEmployeeResponse response = new UpdateEmployeeResponse();
        response.setEmployee(updatedEmployee);
        return response;
    }

    // ========= Find Employee by ID =========
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeByIdRequest")
    @ResponsePayload
    public GetEmployeeByIdResponse getEmployee(@RequestPayload GetEmployeeByIdRequest request) {
        // Fetch employee by ID and return response
        GetEmployeeByIdResponse response = new GetEmployeeByIdResponse();

        Employee employee = employeeDB.get(request.getId());
        if (employee != null) {
            response.setEmployee(employee);
        }
        return response;
    }

    // ========= Delete Employee By ID =========
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteEmployeeByIdRequest")
    @ResponsePayload
    public DeleteEmployeeByIdResponse deleteEmployee(@RequestPayload DeleteEmployeeByIdRequest request) {
        DeleteEmployeeByIdResponse response = new DeleteEmployeeByIdResponse();

        if (employeeDB.remove(request.getId()) != null) {
            response.setStatus("Employee deleted successfully.");
        } else {
            response.setStatus("Employee not found.");
        }

        return response;
    }

    // ========= Find All =========
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllEmployeesRequest")
    @ResponsePayload
    public GetAllEmployeesResponse getAllEmployees(@RequestPayload GetAllEmployeesRequest request) {
        GetAllEmployeesResponse response = new GetAllEmployeesResponse();
        List<Employee> employeeList = new ArrayList<>(employeeDB.values());
        response.getEmployees().addAll(employeeList);
        return response;
    }
}

