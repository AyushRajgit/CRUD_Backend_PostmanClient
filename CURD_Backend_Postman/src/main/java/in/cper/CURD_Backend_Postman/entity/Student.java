/*
    Main purpose of this file :
   - This file acts as a schema of student data.
   - All JSON data received as req and send back as res will be first converted
   from JSON to java class (entity) for further processing and then converted back
   to JSON.
   - @Entity - it is the special annotation used for such class.
   - No bean creation for this class is needed.
   - @Id - it denote the current attribute is our Primary Key.
   - @GeneratedValue(strategy = GenerationType.IDENTITY) - it is used to tell JPA/Hibernate
   to let the database generate the primary key value, typically using an auto-increment
*/

package in.cper.CURD_Backend_Postman.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private int age;
    private String PrimarySkill;
    private String Address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPrimarySkill() {
        return PrimarySkill;
    }

    public void setPrimarySkill(String primarySkill) {
        PrimarySkill = primarySkill;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
