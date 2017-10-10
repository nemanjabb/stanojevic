package app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import app.model.Admin;


@Component
public interface AdminRepository extends JpaRepository<Admin, Long>{
	
	public Admin findByUsername(String username);
	
}
