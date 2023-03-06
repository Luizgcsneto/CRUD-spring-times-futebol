package com.time.crudspringtime.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.time.crudspringtime.enums.TipoStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@SQLDelete(sql = "UPDATE Time SET status = 'INATIVO' WHERE id = ?")
@Where(clause = "status = 'ATIVO'")
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm", timezone="GMT-3")
    private LocalDateTime dataRegistro;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm", timezone="GMT-3")
    private LocalDateTime dataAtualizacao;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private TipoStatus status = TipoStatus.ATIVO;
}
