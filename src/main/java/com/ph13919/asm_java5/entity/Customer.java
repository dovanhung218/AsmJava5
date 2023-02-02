package com.ph13919.asm_java5.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
 @Entity()

public class Customer {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
     @NotBlank(message = "required code")
     @Column(nullable = false,unique = true)
    private String code;
     @NotBlank(message = "required name")
    private String name;
     @NotBlank(message = "required birthDay")
     @JsonFormat(pattern = "dd/MM/yyyy")
     @Temporal(TemporalType.DATE)
    private String birthDay;
     @NotBlank(message = "required phone")
     @Column(nullable = false,unique = true)
     private String phone;
    private String address;
     @NotBlank(message = "required password")
    private String password;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
