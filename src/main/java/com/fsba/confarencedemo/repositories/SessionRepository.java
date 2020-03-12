package com.fsba.confarencedemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsba.confarencedemo.models.Session;

public interface SessionRepository extends JpaRepository<Session, Long>{

}
