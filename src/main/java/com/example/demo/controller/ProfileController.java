package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/hello")
public class ProfileController {


    //@RequestMapping
	@RequestMapping(value = "/")
    public ModelAndView index(@RequestParam("id") long id) {
	//public ModelAndView index() {
//List<String> a = Arrays.asList("a","b");
////Sets.asse
//Set<String> s = Arrays.stream(new String[] {"a","b"}).collect(Collectors.toSet());


        ModelAndView mav = new ModelAndView("hello");
        //mav.addObject("user", userService.getUser(id));
        mav.addObject("message", "hello work");
        return mav;
    }

    //@RequestMapping
	@RequestMapping(value = "/hello")
    public ModelAndView hello() {
        ModelAndView mav = new ModelAndView("hello");
        //mav.addObject("user", userService.getUser(id));
        //mav.addObject("message", "hello work");
        return mav;
    }

}