package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

//    @GetMapping("hello") //added ("hello") so request handles at pat /hello
//    @ResponseBody
//    public String hello() {
//        return "hello, Spring!";
//    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "goodbye, Spring!";
    }

    // dynamically handles requests of the form /hello?name=whateveryouwanthere  'name' here is same as 'name' in method
    //@GetMapping("hello") -removed this and added RequestMapping
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value="hello")
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";

    }

    //handles requests of the form /hello/whateveryouwanthere
    @GetMapping("hello/{name}")
    public String helloWithPathParameter(@PathVariable String name, Model model) {
        model.addAttribute("greeting", "Hello, " + name + "!");
        return "hello";
    }

//    @GetMapping("form")
//    @ResponseBody
//    public String helloForm() {//this all ties together w/'name' below and above
//        return "<html>" +
//                "<body>" +
//                "<form action='hello'>" +
//                "<input type='text' name='name'>" +
//                "<input type='submit' value='Greet me!'>" +
//                "</form>" +
//                "</body>" +
//                "</html>";
//    }

//post method, same as above w/some revisions(had to comment out above)
    @GetMapping("form")
    public String helloForm() {//this all ties together w/'name' below and above
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names);
        return "hello-list";
    }
}
