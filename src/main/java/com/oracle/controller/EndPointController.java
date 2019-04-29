package com.oracle.controller;

import javax.script.ScriptException;
import javax.validation.Valid;

import org.python.core.PyException;
import org.python.core.PyObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.model.EndPointModel;
import com.oracle.model.ResultModel;
import com.oracle.services.IServices;

@RestController
public class EndPointController {
	
	@Autowired
	IServices service;
	
	@RequestMapping(value="/execute", method=RequestMethod.POST)
	public Object execute(@Valid @RequestBody() EndPointModel end, BindingResult rs) throws PyException, ScriptException{
		if (rs.hasErrors()) {
			return rs.toString();
		}
		PyObject py = service.extractPythonCode(end.getCode());
		ResultModel rm = new ResultModel();
		if (py == null) {
			rm.setResult("");
		}else {
			rm.setResult(py.toString());
		}
		return rm;
	}
}
