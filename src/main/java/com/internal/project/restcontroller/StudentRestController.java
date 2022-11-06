package com.internal.project.restcontroller;

import com.internal.project.model.Student;
import com.internal.project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/student")
@RestController
@CrossOrigin
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @PostMapping("/saveStudent")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.OK);
    }

    @PutMapping("/updateStudent")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.updateStudent(student), HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudent/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long studentId) {
        return new ResponseEntity<>(studentService.deleteStudent(studentId), HttpStatus.OK);
    }

}
