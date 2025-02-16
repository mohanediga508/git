package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Objects;

@RestController
public class StudentController {
    private static HashMap<Integer,Student> h=new HashMap<>();
    static {
        Student s1=new Student(1,"mohan");
        Student s2=new Student(2,"kiran");
        h.put(s1.getId(),s1);
        h.put(s2.getId(),s2);
    }
    @RequestMapping("/")
    public ResponseEntity<Object> start(){
        return new ResponseEntity<>("welcome to this page", HttpStatus.OK);
    }
    @RequestMapping("/students/all")
    public ResponseEntity<Object> getAll(){
        return new ResponseEntity<>(h, HttpStatus.OK);
    }
    @RequestMapping("/student")
    public ResponseEntity<Object> get(@RequestParam int id){
        if (h.containsKey(id))
            return new ResponseEntity<>(h.get(id), HttpStatus.OK);
        //return new ResponseEntity<>("data not found", HttpStatus.NOT_FOUND);
        throw  new NoDataFound("data with that specific id "+id+" is not available");
    }
}
