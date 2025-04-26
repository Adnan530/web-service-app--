# web-service-app--
This is a basic Spring Boot application that generates a WSDL (Web Services Description Language) file for a SOAP web service. It's designed as a minimal example to demonstrate how to expose a SOAP endpoint using Spring Web Services.

#Webservice URL: 
	http://localhost:8080/employee
Headers:
	Content-Type:text/xml
	SOAPAction:

======== Create ===================

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:emp="http://example.com/employee">
   	<soapenv:Header/>
   	<soapenv:Body>
		<emp:createEmployeeRequest>
       			<emp:employee>
            			<emp:id>0</emp:id> <!-- ID will be auto-generated -->
            			<emp:name>Adnan Ali Jamali</emp:name>
            			<emp:department>Software Engineer</emp:department>
         		</emp:employee>
      		</emp:createEmployeeRequest>
   	</soapenv:Body>
</soapenv:Envelope>

 	

============== Update ===============

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:emp="http://example.com/employee">
   <soapenv:Header/>
   <soapenv:Body>
      <emp:updateEmployeeRequest>
         <emp:employee>
            <emp:id>1</emp:id> <!-- Existing employee ID -->
            <emp:name>Jane Smith</emp:name>
            <emp:department>Finance</emp:department>
         </emp:employee>
      </emp:updateEmployeeRequest>
   </soapenv:Body>
</soapenv:Envelope>

================ FIND BY ID ===================

<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns2:getEmployeeByIdResponse xmlns:ns2="http://example.com/employee">
            <ns2:employee>
                <ns2:id>1</ns2:id>
                <ns2:name>Jane Smith</ns2:name>
                <ns2:department>Finance</ns2:department>
            </ns2:employee>
        </ns2:getEmployeeByIdResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>

============== DELETE BY ID ==================

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:emp="http://example.com/employee">
   <soapenv:Header/>
   <soapenv:Body>
      <emp:deleteEmployeeByIdRequest>
         <emp:id>1</emp:id>
      </emp:deleteEmployeeByIdRequest>
   </soapenv:Body>
</soapenv:Envelope>

============ FIND ALL =====================

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:emp="http://example.com/employee">
   <soapenv:Header/>
   <soapenv:Body>
      <emp:getAllEmployeesRequest/>
   </soapenv:Body>
</soapenv:Envelope>
