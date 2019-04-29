package com.oracle.services;

import javax.script.ScriptException;

import org.python.core.PyException;
import org.python.core.PyObject;

public interface IServices {
	
	public PyObject extractPythonCode(String code) throws PyException, ScriptException;

}
