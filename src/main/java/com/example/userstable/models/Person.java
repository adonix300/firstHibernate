package com.example.userstable.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(schema = "hibernate")
public class Person {
    @EmbeddedId
    private Contact contact;
    @Column(length = 13)
    private String phone_number;
    @ManyToOne(optional = false)
    private City city;

    @Override
    public String toString() {
        return "Person{" +
                "nameSurnameAge=" + contact +
                ", phone_number='" + phone_number + '\'' +
                ", city=" + city +
                '}';
    }
}

