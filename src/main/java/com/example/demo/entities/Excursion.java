package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="excursions")
@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor

public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="excursion_id", nullable = false, updatable = false)
    private Long id;

    @Column(name="excursion_title")
    @JsonProperty("exursion_title")
    private String excursion_title;

    @Column(name="excursion_price")
    private BigDecimal excursion_price;

    @Column(name="image_url")
    @JsonProperty("image_URL")
    private String image_URL;

    @Column(name="create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name="last_update")
    @UpdateTimestamp
    private Date last_update;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacation_id")
    private Vacation vacation;

    //The uml has a lowercase "i" here. I believe that to be a typo in the UML
    @ManyToMany(mappedBy = "excursions")
    private Set<CartItem> cartItems;

}
