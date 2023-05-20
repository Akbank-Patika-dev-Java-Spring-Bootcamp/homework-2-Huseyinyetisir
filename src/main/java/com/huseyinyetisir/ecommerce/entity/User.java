package com.huseyinyetisir.ecommerce.entity;


import com.huseyinyetisir.ecommerce.enums.UserType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="APPUSER")
@Getter
@Setter
public class User extends BaseEntity{

    @Id
    @GeneratedValue(generator = "AppUser",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Appuser", sequenceName = "APPUSER_ID_SEQ")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "SURNAME", length = 100, nullable = false)
    private String surname;

    @NotBlank
    @Column(name = "USERNAME", length = 200, nullable = false)
    private String username;

    @NotNull
    @Column(name="PASSWORD", length = 400, nullable = false)
    private String password;

    @Email
    @Column(name = "EMAIL", length = 100, nullable = false)
    private String email;


//    @NotBlank
//    @Column(name = "PHONE_NUMBER", length = 20, nullable = false)
//    private String phoneNumber;
//
    @Column(name = "USER_TYPE", length = 30,nullable = false)
    @Enumerated
    private UserType userType;

}
