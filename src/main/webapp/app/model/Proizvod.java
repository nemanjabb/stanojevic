package app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Proizvod {
	
	@Id
	@GeneratedValue
	private Long id;
	private String proizvod;
	private String slika;
	public Proizvod() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProizvod() {
		return proizvod;
	}
	public void setProizvod(String proizvod) {
		this.proizvod = proizvod;
	}
	public String getSlika() {
		return slika;
	}
	public void setSlika(String slika) {
		this.slika = slika;
	}
	
	
	
}
