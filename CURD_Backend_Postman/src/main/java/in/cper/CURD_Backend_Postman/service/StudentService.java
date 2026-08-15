/*
   Main purpose of this file :
   - After receiving the normalized entity request, here all the business logics are performed.
   - Further the data are sent to be stored in database and response is returned.
   - @Service - it is a special annotation used for this type of class.

*/

package in.cper.CURD_Backend_Postman.service;

import in.cper.CURD_Backend_Postman.entity.Student;
import in.cper.CURD_Backend_Postman.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Optional<Student> createStudent(Student student) {
        Student newStudent = studentRepository.save(student);
        if (newStudent == null) return Optional.empty();
        return Optional.of(newStudent);
    }

    public Optional<Student> getStudent(Long id) {
        Optional<Student> studentRes = studentRepository.findById(id);
        if (studentRes.isEmpty()) return Optional.empty();
        return studentRes;
    }

    public Optional<List<Student>> getAllStudents() {
        List<Student> studentRes = studentRepository.findAll();
        if (studentRes.isEmpty()) return Optional.empty();
        return Optional.of(studentRes);
    }

    public Optional<Student> updateStudent(Long id, Student student) {
        Optional<Student> existingStudent = studentRepository.findById(id);

        if (existingStudent.isEmpty()) return Optional.empty();

        Student updatedStudent = existingStudent.get();
        updatedStudent.setName(student.getName());
        updatedStudent.setEmail(student.getEmail());
        updatedStudent.setAge(student.getAge());
        updatedStudent.setPrimarySkill(student.getPrimarySkill());
        updatedStudent.setAddress(student.getAddress());

        studentRepository.save(updatedStudent);
        return Optional.of(updatedStudent);
    }

    public Optional<Student> deleteStudentById(Long id) {
        Optional<Student> studentRes = studentRepository.findById(id);
        if (studentRes.isEmpty()) return Optional.empty();

        studentRepository.deleteById(id);
        return studentRes;
    }
}
