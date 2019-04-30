package com.oracle;

import javax.script.ScriptException;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.python.core.PyException;
import org.python.core.PyObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.oracle.services.ServicesImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OracleTestProjectApplicationTests {

	@Autowired
	ServicesImpl service;

	@Test
	public void whenPythonCodeIsProvided_thenRetrievedResultIsCorrect() throws PyException, ScriptException {
		PyObject testPy = service.extractPythonCode("%python print 1+1");
		Assert.assertEquals("2", testPy.toString());
	}
	
	@Test
	public void whenPythonCodeIsProvided_thenRetrievedResultIsIncorrect() throws PyException, ScriptException {
		service.extractPythonCode("%python a = 1+1");
		PyObject testPy = service.extractPythonCode("%python print a+2");
		Assert.assertEquals("4", testPy.toString());
	}
	
	@Test
	public void whenPythonCodeIsProvided_thenRetrievedResultIsCorrectAss() throws PyException, ScriptException {
		PyObject testPy = service.extractPythonCode("%python print 2+2");
		Assert.assertEquals("4", testPy.toString());
	}

}
