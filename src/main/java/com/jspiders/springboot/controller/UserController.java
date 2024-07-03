package com.jspiders.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.springboot.pojo.User;
import com.jspiders.springboot.response.ResponseStructure;
import com.jspiders.springboot.service.UserService;

@RestController
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@PostMapping(path = "/user")
	public ResponseStructure<User> addUser(@RequestBody User user) {
		User addedUser = userService.addUser(user);
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		if (addedUser != null) {
			responseStructure.setMessage("USER ADDED");
			responseStructure.setHttpStatus(HttpStatus.CREATED);
			responseStructure.setHttpStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(addedUser);
		} else {
			responseStructure.setMessage("USER NOT ADDED");
			responseStructure.setHttpStatus(HttpStatus.BAD_REQUEST);
			responseStructure.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
		}
		return responseStructure;
	}
	
//	 @GetMapping(path = "/product/byUser")
//	    public ResponseStructure<User> findProductByUserEmailAndPassword(@RequestParam(name = "email") String email,
//	                                                                        @RequestParam(name = "password") String password) {
//	        User user = userService.findProductByUserEmailAndPassword(email, password);
//	        ResponseStructure<User> responseStructure = new ResponseStructure<>();
//	        if (user != null) {
//	            responseStructure.setMessage("PRODUCT FOUND");
//	            responseStructure.setHttpStatus(HttpStatus.OK);
//	            responseStructure.setHttpStatusCode(HttpStatus.OK.value());
//	            responseStructure.setData(user);
//	        } else {
//	            responseStructure.setMessage("PRODUCT NOT FOUND");
//	            responseStructure.setHttpStatus(HttpStatus.NOT_FOUND);
//	            responseStructure.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
//	        }
//	        return responseStructure;
//	    }

}
