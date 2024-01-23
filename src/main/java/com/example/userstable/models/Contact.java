package com.example.userstable.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Contact implements Serializable {
    @Column(nullable = false)
    @JsonProperty
    private String name;

    @Column(nullable = false)
    @JsonProperty
    private String surname;

    @Column(nullable = false)
    @JsonProperty
    private int age;
}

