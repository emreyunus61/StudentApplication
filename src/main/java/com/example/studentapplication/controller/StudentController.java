package com.example.studentapplication.controller;

import com.example.studentapplication.entity.Student;
import com.example.studentapplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentDetails")
public class StudentController {

    @Autowired
    private StudentService service;


    @PostMapping("/saveStudent")
    public ResponseEntity<String> saveStudent(@RequestBody Student student){

        Integer id = service.saveStudent(student);
        return  new ResponseEntity<String>("Student with " + id+ "hass been saved" , HttpStatus.OK);

    }

    @GetMapping("/studentList")
    public  ResponseEntity<List<Student>> getAllStudentsDetails(){

        List<Student> list = service.getAllStudents();
        return new ResponseEntity<List<Student>>(list,HttpStatus.OK);

    }

    @GetMapping("getStudentById/{sno}")
    public  ResponseEntity<Student>  getStudentById(@PathVariable("sno") Integer sno){

        Student std = service.getStudentById(sno);
        return  new ResponseEntity<Student>(std,HttpStatus.OK);
    }

    @PutMapping("/updateStudent/{sno}")
    public ResponseEntity<String> updateStudent( @PathVariable("sno") Integer sno, @RequestBody Student student){


        Student stdFromDb = service.getStudentById(sno);
        stdFromDb.setStdName(student.getStdName());
        stdFromDb.setStdClass(student.getStdClass());
        stdFromDb.setSchoolName(student.getSchoolName());
        Integer id = service.saveStudent(stdFromDb);
        return new ResponseEntity<String>("Student with " + id + "has been update",HttpStatus.OK);

    }

    public ResponseEntity<String> deleteStudent(@PathVariable("sno") Integer sno){

        service.deleteStudent(sno);
        return  new ResponseEntity<String>("student with " + sno+ "has been deleted", HttpStatus.OK);

    }


}
