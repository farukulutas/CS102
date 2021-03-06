package spring.helloworld.demo.controller;

import spring.helloworld.demo.model.Person;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller 
public class HelloWorldController{

 @GetMapping( "hello-world")
 public String sayHello(Model model, @RequestParam(required=false) String name){
  String message;
  if(name != null){
   message = "Hello " + name;
  }
  else{
   message = "Provide your parameter as follows, localhost:8080/hello-world?name=David";
  }
  
  model.addAttribute("message", message);
  return "hello-world";
 }
 
 @GetMapping("hello-world-json")
 public ResponseEntity<Object> returnInformationAsJson(){
  List<Object> personList = new ArrayList<>();
  personList.add(new Person("Faruk", 19));
  personList.add(new Person("David", 34));
  
  return new ResponseEntity<>(personList,HttpStatus.OK);
 }
}