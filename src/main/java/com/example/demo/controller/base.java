package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

abstract class BaseController {
	@Autowired
	protected Gson gson;
}
