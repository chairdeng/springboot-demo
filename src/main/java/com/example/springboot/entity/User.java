package com.example.springboot.entity;

import com.example.springboot.enums.SexEnum;
import com.example.springboot.repository.converter.SerializableEnumConverter;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;


import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

/**
 * *****************************************
 *
 * @author 邓超【dengchao5@jd.com】
 * @date 2017/3/31 17:49
 * *****************************************
 */
@Data
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

//    private Account account;

    @NotBlank(message = "{user.name.blank.error}")
    private String name;

    @Past
    @Temporal(TemporalType.DATE)
    private Date birthday;

//    @Convert(converter = SerializableEnumConverter.class)
    private SexEnum sex;

    private boolean vip;

    @Pattern(regexp = "^1[0-9]{10}$")
    private String phone;

    @Email
    private String email;

//    @NotEmpty
//    private List<Address> addresses;
}
