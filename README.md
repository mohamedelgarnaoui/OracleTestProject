# OracleTestProject
Overview
Python interpreter using Jython. And Spring boot 1.5.20.Release

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::       (v1.5.20.RELEASE)
Architecture
Current interpreter implementation using spring boot and Jython.

Details:
•	Tests :
Run as java application or as Spring boot app.
The OracleTestProjectApplication is the main class when we can start this project.
The Endpoint execute function take as parameter a json like this:
{
	"code":"%python code "
}
For Example :
{
	"code":"%python print 2"
}
The expected result is like this:
{
    "result": "Result"
}
For example:
{
    "result": "2"
}
The Python Interpreter take in consideration all the variable state for example:
The follow input produce nothing because it is just a query assignment:
{
	"code":"%python a = 2"
}
The result is:
{
    "result": ""
}
And when I send this :
{
	"code":"%python print a+2"
}
The result is taking a variable value plus 2:
{
    "result": "4"
}



•	Unit Tests : 
To run unit test just run OracleTestProjectApplicationTests or SpringBootRestControllerTest for the controller testing 
 


 
