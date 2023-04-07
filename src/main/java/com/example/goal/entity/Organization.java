package com.example.goal.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organization_seq_gen")
    @SequenceGenerator(name = "organization_seq_gen", sequenceName = "org_seq")
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "organization", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Employees> employees = new HashSet<>();
}
