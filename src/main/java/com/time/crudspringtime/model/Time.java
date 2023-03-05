package com.time.crudspringtime.model;

import java.io.Serializable;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
@SQLDelete(sql = "UPDATE Time SET status = 'Inativo' WHERE id = ?")
@Where(clause = "status = 'Ativo'")
public class Time implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @NotBlank
    @NotNull
    @Column(length = 30)
    private String nome;

    @NotBlank
    @NotNull
    @Column(length = 50)
    private String estado;

    @NotBlank
    @NotNull
    @Column(length = 50)
    private String cores;

    @Pattern(regexp = "Ativo|Inativo")
    private String status = "Ativo";
}
