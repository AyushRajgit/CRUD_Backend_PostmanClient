/*
   Main purpose of this file :
   - It extends the functionality of JpaRepository<Entity,PrimaryKey>
   - The JPA makes our work easier, just we need to call the required function
   and it automatically performs the SQL Query to deal with our database.
   - JPA (Java Persistence API) helps us interact with a relational database
   using Java objects instead of writing SQL for every operation.

*/

package in.cper.CURD_Backend_Postman.repository;

import in.cper.CURD_Backend_Postman.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {

    Optional<Student> findByIdAndDeletedFalse(Long id);

    List<Student> findByDeletedFalse();

    Student findByEmailAndDeletedTrue(String email);
}
