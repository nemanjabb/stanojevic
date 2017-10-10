package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.model.Proizvod;
import app.repository.ProizvodRepository;

@Component
public class ProizvodService {
	
	@Autowired
	ProizvodRepository proizvodRepository;
	
	public List<Proizvod> findByTip(String tip){
		return proizvodRepository.findByProizvod(tip);
	}
	
	public Proizvod findById(Long id) {
		return proizvodRepository.findOne(id);
	}
	
	public void save(Proizvod proizvod) {
		proizvodRepository.save(proizvod);
	}
	public void delete(Long id) {
		proizvodRepository.delete(id);
	}
	
}
