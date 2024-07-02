package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="divisions")
@Getter
@Setter
@NoArgsConstructor


public class Division {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="division_id")
    private Long id;

    @Column(name="division")
    private String division_name;

    @Column(name="create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name="last_update")
    @UpdateTimestamp
    private Date last_update;

    @ManyToOne
    @JoinColumn(name="country_id", nullable = false, updatable = false, insertable = false)
    private Country country;

    @Column(name = "country_id")
    private Long country_id;

    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Customer> customers;


}
