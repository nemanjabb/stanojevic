package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.model.Slideshow;
import app.repository.SlideshowRepository;

@Component
public class SlideshowService {

	@Autowired
	SlideshowRepository slideshowRepository;
	
	public List<Slideshow> findAll(){
		return slideshowRepository.findAll();
	}
	public Slideshow findById(Long id) {
		return slideshowRepository.findOne(id);
	}
	public void save(Slideshow slideshow) {
		slideshowRepository.save(slideshow);
	}
	public void delete(Long id) {
		slideshowRepository.delete(id);
	}
}
