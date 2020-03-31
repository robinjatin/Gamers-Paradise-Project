package com.example.springbootmongodb.controller;

import com.example.springbootmongodb.model.Person;
import com.example.springbootmongodb.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin( origins = "http://localhost:4200")
public class PersonController {
    @Autowired
    private PersonService personService;
    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public String create(@RequestParam String firstName,@RequestParam String eMail,@RequestParam int age,@RequestParam String password,@RequestParam String number){
        Person p=personService.create(firstName,eMail,age,password,number);
        return p.toString();
    }
    @RequestMapping(method = RequestMethod.POST,value = "/create")
    public String create(@RequestBody Person person){
        personService.create(person);
        return("Hey, "+ person.getFirstName() +" "+ person.geteMail()+" you have registered successfully");
    }
    @RequestMapping("/get")
    public Person getPerson(@RequestParam String firstName){
        return personService.findByFirstName(firstName);
    }
    @RequestMapping("/getAll")
    public List<Person> getAllPerson(){
        return personService.getAll();
    }
    @RequestMapping("/update")
    public String update(@RequestParam String firstName,@RequestParam String eMail,@RequestParam int age,@RequestParam String password,@RequestParam String number){
        Person p=personService.update(firstName,eMail,age,password,number);
        return p.toString();
    }
    @RequestMapping("/delete")
    public String delete(@RequestParam String firstName){
        personService.delete(firstName);
        return "Deleted "+firstName;
    }
    @RequestMapping("/deleteAll")
    public String deleteAll(){
        personService.deleteAll();
        return "Deleted All Records";
    }
}
