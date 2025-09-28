package com.bitGeeksCRUDAPI.CRUDAPI.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Student")
public class StudentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registeration_no", nullable = false, updatable = false)
    private Long registration_no;

    @NotNull(message = "Roll number must not be null")
    private Long roll_no;

    @NotBlank(message = "Name must not be blank")
    private String name;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email must not be blank")
    private String email;

    @NotBlank(message = "Phone must not be blank")
    private String phone;

    @Version  // For optimistic locking (concurrency control)
    private Long version;

    public StudentModel() {
    }

    public StudentModel(Long roll_no, String name, String email, String phone) {
        this.roll_no = roll_no;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.version = 0L; // Initialize version
    }


    public Long getRegisteration_no() {
        return registration_no;
    }

    public void setRegisteration_no(Long registeration_no) {
        this.registration_no = registeration_no;
    }

    public Long getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(Long roll_no) {
        this.roll_no = roll_no;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        phone = phone;
    }

    public Long getVersion() { return version; }
    public void setVersion(Long version) { this.version = version; }
}
