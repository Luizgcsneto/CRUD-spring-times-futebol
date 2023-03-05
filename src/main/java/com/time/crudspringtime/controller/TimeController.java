package com.time.crudspringtime.controller;

import com.time.crudspringtime.dto.TimeDto;
import com.time.crudspringtime.service.TimeService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.validation.annotation.Validated;


@Validated
@RestController
@RequestMapping("api/time")
public class TimeController {

  
    private final TimeService timeService;

    public TimeController(TimeService timeService)
    {
        this.timeService = timeService;
    }

    @GetMapping
    @ResponseBody
    public List<TimeDto> listaTimes() 
    {
        return timeService.listaTimes();
    }

    @GetMapping("/{id}")
    public TimeDto findById(@PathVariable @NotNull @Positive Long id) 
    {
        return timeService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TimeDto create(@RequestBody @Valid TimeDto timeDto) 
    {
        return  timeService.create(timeDto);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public TimeDto update(@PathVariable @NotNull @Positive Long id,
            @RequestBody @Valid @NotNull TimeDto timeDto) {
        return timeService.update(id, timeDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id) 
    {
        timeService.delete(id);
    }

}
