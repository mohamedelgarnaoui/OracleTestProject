package com.oracle;

import static org.junit.Assert.assertEquals;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.oracle.model.EndPointModel;

public class SpringBootRestControllerTest extends AbstractTest{

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void TestExecute() throws Exception {
		String uri = "/execute";
		EndPointModel ep = new EndPointModel();
		ep.setCode("%python print 2");;
		String inputJson = super.mapToJson(ep);
		System.out.println(inputJson);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		/*	serialize the content that will be the return of Python code
		*	the json.toString() will output : {"result":"2"}
		*/
		JSONObject json = new JSONObject( "{\"result\":\"2\"}");
		assertEquals(content, json.toString());
	}
}
