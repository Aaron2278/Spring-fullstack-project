package com.codedifferently.fullstackspring.domain.employee.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity // JPA saves to database
@NoArgsConstructor // Non args constructor
@RequiredArgsConstructor // parameterized constructor
@Data // getters and setters
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String email;

    public String toString(){
        return String.format("%d %s %s %s", id, firstName, lastName, email);
    }
}
