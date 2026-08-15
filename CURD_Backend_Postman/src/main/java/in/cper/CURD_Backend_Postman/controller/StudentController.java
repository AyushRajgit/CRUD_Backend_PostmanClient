/*
   Main purpose of this file :
   - It serves to receive the HTTP Request from client and normalize it by
   converting it from JSON to java class (entity).
   - It passes it to other classes for performing business logic.
   - And then return the JSON response with some status code.
   - Here, we create all CURD operations, set up the end-points.
   - @RestController - it is the special annotation used for such class.
   - @RequestMapping(common path) - it is used to map the common path to all
   our methods such that they can further extend it.
   - @RequestBody - it fetches the body of the incoming request and automatically
   convert JSON into java class (entity).
   - @PathVariable - it fetch out the required variable from the incoming path request.
   - @POSTMapping - Annotation for POST (create call)
   - @GetMapping - Annotation for GET (get call)
   - @PutMapping - Annotation for PUT (update call), where we need to send all entries.
   - @PathMapping - Annotation for PATCH (update call), where we need to send only the entries to be changed.
   - @DeleteMapping - Annotation for DELETE (delete call)
*/

package in.cper.CURD_Backend_Postman.controller;

import in.cper.CURD_Backend_Postman.entity.Student;
import in.cper.CURD_Backend_Postman.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
       Optional<Student> studentRes =  studentService.createStudent(student);

       if (studentRes.isEmpty()) {
           return ResponseEntity
                   .status(HttpStatus.NOT_FOUND)
                   .body(null);
       }

        return ResponseEntity.status(HttpStatus.CREATED).body(studentRes.get());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Optional<Student> studentRes = studentService.getStudent(id);

        if (studentRes.isEmpty()) {
            return ResponseEntity
                   .status(HttpStatus.NOT_FOUND)
                   .body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(studentRes.get());
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent() {
        Optional<List<Student>> studentRes = studentService.getAllStudents();

        if (studentRes.isEmpty()) {
            return ResponseEntity
                   .status(HttpStatus.NOT_FOUND)
                   .body(null);
        }

        return  ResponseEntity.status(HttpStatus.OK).body(studentRes.get());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Optional<Student> studentRes = studentService.updateStudent(id, student);

        if (studentRes.isEmpty()) {
            return ResponseEntity
                   .status(HttpStatus.NOT_FOUND)
                   .body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(studentRes.get());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable Long id) {
        Optional<Student> studentRes = studentService.deleteStudentById(id);

        if (studentRes.isEmpty()) {
            return ResponseEntity
                   .status(HttpStatus.NOT_FOUND)
                   .body(null);
        }

        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }
}
