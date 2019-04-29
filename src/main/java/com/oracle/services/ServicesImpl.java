package com.oracle.services;

import java.util.Arrays;
import javax.script.ScriptException;

import org.python.core.PyException;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicesImpl implements IServices{
	@Autowired
	PythonInterpreter interp;
	
	@Override
	public PyObject extractPythonCode(String code) throws PyException, ScriptException {
		//get python request from code variable 
		String[] pythonCode = code.split(" ");
		PyObject x = null;
		pythonCode = Arrays.copyOfRange(pythonCode, 1, pythonCode.length);
		String str = String.join(" ", pythonCode);
		
		// check if it is print request or just an variable assignment.
		if (str.contains("print")) {
			str = str.replace("print", "printe =");
			interp.exec(str);
			x = interp.get("printe");
		}else {
			interp.exec(str);
		}
		return x;
	}

}
