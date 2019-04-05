package com.bpeak.Controller;

import com.bpeak.Entity.Student;
import com.bpeak.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value="", method = RequestMethod.GET)
    public Collection<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @RequestMapping(value="", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateStudentById(@RequestBody Student student){
        studentService.updateStudentById(student);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void removeStudentById(@PathVariable int id){
        studentService.removeStudentById(id);
    }

    @RequestMapping(value="", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertStudent(@RequestBody Student student){
        this.studentService.insertStudent(student);
    }
}
