package com.fsba.confarencedemo.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.fsba.confarencedemo.models.Speaker;
import com.fsba.confarencedemo.repositories.SpeakersRepository;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {
	
	@Autowired
	private SpeakersRepository speakersRepository;
	
	@GetMapping
	public List<Speaker> list(){
		return speakersRepository.findAll();
	}
	@GetMapping
	@RequestMapping("{id}")
	public Speaker get(@PathVariable Long id) {
		return speakersRepository.getOne(id);
		
	}
	@PostMapping
	public Speaker create(@RequestBody final Speaker speaker) {
		return speakersRepository.saveAndFlush(speaker);
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		speakersRepository.deleteById(id);
		
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.PUT)
	public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
		Speaker existingSpeaker=speakersRepository.getOne(id);
		 BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
		 return speakersRepository.saveAndFlush(existingSpeaker);
		
	}

}
