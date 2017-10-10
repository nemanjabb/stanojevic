package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import app.model.Proizvod;

@Component
public interface ProizvodRepository extends JpaRepository<Proizvod, Long>{
	
	public List<Proizvod> findByProizvod(String proizvod);
	
}
