package com.time.crudspringtime.dto.mapper;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.stereotype.Component;

import com.time.crudspringtime.dto.TimeDto;
import com.time.crudspringtime.model.Time;

@Component
public class TimeMapper {
    
    public TimeDto toDto(Time time){
        if (time == null){
            return null;
        }

        return new TimeDto(time.getId(), time.getNome(), time.getEstado(), time.getCores());
    }

    public Time toEntity(TimeDto timeDto){
        if (timeDto == null) {
            return null;
        }
        Time time = new Time();

        if(timeDto.id() != null){
            time.setId(timeDto.id());
        }

        time.setNome(timeDto.nome());
        time.setEstado(timeDto.estado());
        time.setCores(timeDto.cores());
        time.setDataRegistro(LocalDateTime.now(ZoneId.of("GMT-3")));

        return time;
    }
}
