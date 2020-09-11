package com.tutorial.springbootswaggerexample.entity;

import com.sun.xml.txw2.annotation.XmlValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.websocket.OnOpen;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    private String email;
}