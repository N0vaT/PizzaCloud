package com.nova.pizzaCloud.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Taco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(max = 20, min = 3, message = "The name must be less than 3-20 characters")
    private String name;
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    @NotNull
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    @ManyToMany
    private List<Ingredient> ingredients;
}
