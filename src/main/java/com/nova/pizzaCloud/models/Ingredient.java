package com.nova.pizzaCloud.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(force=true)
@Entity
public class Ingredient {
    @Id
    private String id;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
