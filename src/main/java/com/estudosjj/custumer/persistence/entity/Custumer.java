package com.estudosjj.custumer.persistence.entity;

import jakarta.persistence.*;

import java.util.function.Function;

@Entity //Atributos do banco de dados
@Table(name = "Custumer")
public class Custumer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)// gera valor automatico no id
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "document", nullable = false)
    private String document;



    public <R> R map(Function<Custumer, R> func){
        return func.apply(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}
