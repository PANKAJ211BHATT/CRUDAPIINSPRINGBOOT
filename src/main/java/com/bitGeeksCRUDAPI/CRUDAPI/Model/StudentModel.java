package com.bitGeeksCRUDAPI.CRUDAPI.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "Student")
public class StudentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registeration_no;

    private long roll_no;
    private String name;
    private String email;
    private String Phone;



    public StudentModel() {
    }
    public StudentModel(Long registeration_no, long roll_no, String name, String email, String phone) {
        this.registeration_no = registeration_no;
        this.roll_no = roll_no;
        this.name = name;
        this.email = email;
        Phone = phone;
    }


    public Long getRegisteration_no() {
        return registeration_no;
    }

    public void setRegisteration_no(Long registeration_no) {
        this.registeration_no = registeration_no;
    }

    public long getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(long roll_no) {
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
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
