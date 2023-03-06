package com.time.crudspringtime.repository;

import com.time.crudspringtime.model.Time;


import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRepository extends JpaRepository<Time,Long> {}
