package com.time.crudspringtime.service;

import com.time.crudspringtime.repository.TimeRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import com.time.crudspringtime.dto.TimeDto;
import com.time.crudspringtime.dto.mapper.TimeMapper;
import com.time.crudspringtime.exception.RecordNotFoundException;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class TimeService {

    private final TimeRepository timeRepository;
    private final TimeMapper timeMapper;

    public TimeService(TimeRepository timeRepository,
    TimeMapper timeMapper) {
        this.timeRepository = timeRepository;
        this.timeMapper = timeMapper;
    }

    public List<TimeDto> listaTimes() 
    {
        return timeRepository.findAll()
        .stream().map(timeMapper::toDto)
        .collect(Collectors.toList());
    }


    public TimeDto findById(@PathVariable @Positive Long id)
    {
        return timeRepository.findById(id).map(timeMapper::toDto)
        .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public TimeDto create(@Valid @NotNull TimeDto timeDto)
    {
        return timeMapper.toDto(timeRepository.save(timeMapper.toEntity(timeDto)));
    }

    public TimeDto update (@NotNull @Positive Long id, @Valid @NotNull TimeDto timeDto)
    {
        return timeRepository.findById(id).map(time -> {
            time.setNome(timeDto.nome());
            time.setEstado(timeDto.estado());
            time.setCores(timeDto.cores());
            time.setDataAtualizacao(LocalDateTime.now(ZoneId.of("GMT-3")));
            return timeMapper.toDto(timeRepository.save(time));
        }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@PathVariable @NotNull @Positive Long id)
    {
        timeRepository.delete(timeRepository.findById(id)
        .orElseThrow(() -> new RecordNotFoundException(id)));
    }



}
