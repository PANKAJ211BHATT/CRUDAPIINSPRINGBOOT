package com.bitGeeksCRUDAPI.CRUDAPI.dto;

import jakarta.persistence.Version;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class StudentDTO {
    private Long registeration_no;

    @NotBlank(message = "Roll number must not be blank ")
    private String name;

    @NotBlank(message = "Roll number must not be blank ")
    private long roll_no;
    @Email(message = "Email should be valid")
    @NotBlank(message = "Roll number must not be blank ")
    private String email;

    @NotBlank(message = "Roll number must not be blank ")
    private String Phone;

    @Version  // For optimistic locking (concurrency control)
    private Long version;

    public StudentDTO() {
    }
    public StudentDTO( Long roll_no,long rollNo, String name, String email, String phone) {
        this.roll_no = roll_no;
        this.name = name;
        this.email = email;
        this.Phone = phone;
    }



    public long getRegisteration_no() {
        return registeration_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(long roll_no) {
        this.roll_no = roll_no;
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
