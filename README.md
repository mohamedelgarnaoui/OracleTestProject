# OracleTestProject
## Overview
Python interpreter Spring boot 1.5.20.Release

## Architecture
Python interpreter implementation using spring boot.


## Details:
**_The interpreter is for python code executing and also take in consederation all variable state._**
### •	Tests :
Run as java application or as Spring boot app.
The ``` OracleTestProjectApplication ``` is the main class when we can start this project.

The execute Rest Controller Endpoint function take as parameter a json like this:
```
{
	"code":"%python code "
} 
```
The expected result is like this:
```
{
	"result": "Result"
}
```
For Example :
```
{
	"code":"%python print 2"
}
```
```
{
	"result": "2"
}
```
The Python Interpreter take in consideration all the variable state for example:
The follow input produce nothing because it is just a query assignment:
```
{
	"code":"%python a = 2"
}
```

The result is:
```
{
	"result": ""
}
```
And when I send this :
```
{
	"code":"%python print a+2"
}
```
The result is taking "a" variable value plus 2:
```
{
	"result": "4"
}
```


### •	Unit Tests based on JUNIT and Spring Boot test: 
To run unit test just run ``` OracleTestProjectApplicationTests ```or ``` SpringBootRestControllerTest ``` for the controller testing in ``` OracleTestProject/src/test/java/com/oracle/ ``` folder.
 


 
