package com.estudosjj.custumer.model.request;

import jakarta.validation.constraints.NotBlank;

public class CustumerRequest {
    @NotBlank//Não pode vir vazia
    private String name;
    @NotBlank
    private String document;

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
