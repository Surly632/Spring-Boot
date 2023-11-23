package com.example.practice.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;
   @Column(name = "name", nullable = false)
   @NotBlank(message="name cannot be empty or null!")
    private String name;
//    private String id_no;
//    private String mobile;
//    private String email;
//    private String fathers_name;
//    private String mothers_name;

}
