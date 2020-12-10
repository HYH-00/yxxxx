package com.hh.demo.controller;

import com.hh.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.soap.Addressing;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;
}
