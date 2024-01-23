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
@Table(schema = "hibernate", name = "persons")
public class Person {
    @EmbeddedId
    private Contact contact;
    @Column(name = "phone_number",length = 13)
    private String phoneNumber;
    @ManyToOne(optional = false)
    private City city;

    @Override
    public String toString() {
        return "Person{" +
                "nameSurnameAge=" + contact +
                ", phone_number='" + phoneNumber + '\'' +
                ", city=" + city +
                '}';
    }
}

