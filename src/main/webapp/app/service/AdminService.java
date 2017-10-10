package app.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.model.Admin;
import app.repository.AdminRepository;

@Component
public class AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	private static MessageDigest md;
	
	public Admin findByUserName(String username) {
		return adminRepository.findByUsername(username);
	}
	
	public void saveAdmin(Admin admin) {
		adminRepository.save(admin);
	}
	
	public String cryptPass(String pass) throws NoSuchAlgorithmException{
        md=MessageDigest.getInstance("MD5");
        byte[] passBytes = pass.getBytes();
        md.reset();
        byte[] digested = md.digest(passBytes);
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<digested.length;i++){
            sb.append(Integer.toHexString(0xff & digested[i]));
        }
        return sb.toString();
    }
	
}
