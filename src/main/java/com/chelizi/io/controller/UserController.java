package com.chelizi.io.controller;

import com.alibaba.fastjson.JSONObject;
import com.chelizi.io.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@RequestMapping(value="/getUser",method=RequestMethod.GET)
	public JSONObject getUserById(){
		return (JSONObject)JSONObject.toJSON(userService.getUserById(1));
	}
}
