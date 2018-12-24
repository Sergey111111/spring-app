package ru.job4j.springapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * This is car model mapped with entities.
 * MySQL Doesn't support booleans so there's a reason I used tiny int
 */
@Entity
@Table(name = "cars")
@Data
@NoArgsConstructor
public class Car {
    private String name;
    private String body;
    private String engine;
    private String color;
    private Timestamp created;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int price;
    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private boolean sold;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private  User user;
}
