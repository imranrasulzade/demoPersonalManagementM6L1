package com.matrix.demotestapp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Person {
    private int id;
    private String name;
    private String surname;
    private String phone;
    private String address;
    private int status;

}
