package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import app.model.Slideshow;


@Component
public interface SlideshowRepository extends JpaRepository<Slideshow, Long>{

}
