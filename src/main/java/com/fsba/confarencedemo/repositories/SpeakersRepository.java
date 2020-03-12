package com.fsba.confarencedemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsba.confarencedemo.models.Speaker;

public interface SpeakersRepository extends JpaRepository<Speaker, Long>{

}
