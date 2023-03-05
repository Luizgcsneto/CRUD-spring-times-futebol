package com.time.crudspringtime.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record TimeDto (
    @JsonProperty("_id") Long id, 
    @NotBlank @NotNull  @Column(length = 30) String nome, 
    @NotBlank @NotNull  @Column(length = 50) String estado,
    @NotBlank @NotNull  @Column(length = 50) String cores
) {
    
}
