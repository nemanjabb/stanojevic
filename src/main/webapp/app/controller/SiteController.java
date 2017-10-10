package app.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import app.model.Admin;
import app.model.Proizvod;
import app.model.Slideshow;
import app.service.AdminService;
import app.service.ProizvodService;
import app.service.SlideshowService;

@Controller
public class SiteController {
	
	@Autowired
	SlideshowService slideshowService;
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	ProizvodService proizvodService;
	
	@RequestMapping("/")
    public String index(ModelMap model){
        List<Slideshow> lista = slideshowService.findAll();
        model.addAttribute("slide",lista);
		return "index";
    }
	
	@RequestMapping("/login")
	public String logInForm(HttpServletRequest request,ModelMap model){
		HttpSession session = request.getSession();
		List<Slideshow> lista = slideshowService.findAll();
		model.addAttribute("slide", lista);
		if(session.getAttribute("admin")!=null){
			return "admin";
		}
		return "login";
	}
	
	@RequestMapping("/admin")
	public String addNewProduct(ModelMap model, HttpServletRequest request, @RequestParam (required = false) String username,@RequestParam (required = false) String password) throws NoSuchAlgorithmException{
		HttpSession session = request.getSession();
		List<Slideshow> lista = slideshowService.findAll();
		model.addAttribute("slide", lista);
		if(session.getAttribute("admin")==null){
			if(username==null||username.isEmpty()){
				return "login";
			}
			if(password==null||password.isEmpty()){
				return "login";
			}
			Admin admin = adminService.findByUserName(username);
			System.out.println(admin);
			if(admin==null||!admin.getPassword().equals(adminService.cryptPass(password))){
				return "login";
			}else{
				session.setAttribute("admin", admin);
				return "admin";
	    }
	}
	return "admin";
	}
	
	@RequestMapping("/add")
	public String addingNewProduct(@RequestParam (required = false)MultipartFile photo,
	                           @RequestParam (required = false) String proizvod,
	                           HttpServletRequest request,
	                           ModelMap model) throws FileNotFoundException, IOException{
		HttpSession session = request.getSession();
		List<Slideshow> lista = slideshowService.findAll();
		model.addAttribute("slide", lista);
		if(session.getAttribute("admin")!=null){
			if(!photo.isEmpty()&&!proizvod.equals("-1")){    
				String filepath = request.getServletContext().getRealPath("resources/"+proizvod);
				FileOutputStream fos = new FileOutputStream(filepath+"/"+photo.getOriginalFilename());
				fos.write(photo.getBytes());
				fos.close();
				Proizvod p = new Proizvod();
				p.setProizvod(proizvod);
				p.setSlika(photo.getOriginalFilename());
				proizvodService.save(p);
			}    
		return "admin";
	}
	return "login";
	}
	
	@RequestMapping("/aspiratori")
	public String aspiratori(ModelMap model){
		List<Slideshow> lista = slideshowService.findAll();
		model.addAttribute("slide", lista);
		List<Proizvod> list = proizvodService.findByTip("aspiratori");
		model.addAttribute("lista",list);
		return "sablon";
	}
	
	@RequestMapping("/sudopere")
	public String sudopere(ModelMap model){
		List<Slideshow> lista = slideshowService.findAll();
		model.addAttribute("slide", lista);
		List<Proizvod> list = proizvodService.findByTip("sudopere");
		model.addAttribute("lista",list);
		model.addAttribute("tip","sudopere");
		return "sablon";
	}
	
	@RequestMapping("/komadninamestaj")
	public String komode(ModelMap model){
		List<Slideshow> lista = slideshowService.findAll();
		model.addAttribute("slide", lista);
		List<Proizvod> list = proizvodService.findByTip("komode");
		model.addAttribute("lista",list);
		return "komadniNamestaj";
	}
	
	@RequestMapping("/kuhinje")
	public String kuhinje(ModelMap model){
		List<Slideshow> lista = slideshowService.findAll();
		model.addAttribute("slide", lista);
		List<Proizvod> list = proizvodService.findByTip("kuhinje");
		model.addAttribute("lista",list);
		return "sablon";
	}
	
	@RequestMapping("/americkiplakari")
	public String americkiPlakari(ModelMap model){
		List<Slideshow> lista = slideshowService.findAll();
		model.addAttribute("slide", lista);
		List<Proizvod> list = proizvodService.findByTip("americki plakari");
		model.addAttribute("lista",list);
		return "sablon";
	}
	
	@RequestMapping("/akcije")
	public String akcija(ModelMap model,HttpServletRequest request) throws IOException{
		List<Slideshow> lista = slideshowService.findAll();
		model.addAttribute("slide", lista);
		String path = request.getServletContext().getRealPath("resources/akcije");
		File dir = new File(path);
		List<String> list = new ArrayList<String>();
		for(File f:dir.listFiles()){
			list.add(f.getName());
		}
		model.addAttribute("lista", list);
		return "akcije";
	}
	

	@RequestMapping("/boje")
	public String boje(ModelMap model){
		List<Slideshow> lista = slideshowService.findAll();
		model.addAttribute("slide", lista);
		return "boje";
	}
	
	@RequestMapping("/kontakt")
	public String kontakt(ModelMap model){
		List<Slideshow> lista = slideshowService.findAll();
		model.addAttribute("slide", lista);

		return "sablon";
	}
	
	@RequestMapping("/newadmin")
	public String newAdmin(
	    @RequestParam (required = false) String username, 
	    @RequestParam (required = false) String password,
	    HttpServletRequest request,
	    ModelMap model) throws NoSuchAlgorithmException{
		List<Slideshow> lista = slideshowService.findAll();
		model.addAttribute("slide", lista);
		if(request.getSession().getAttribute("admin")!=null){
			String pass = adminService.cryptPass(password);
			Admin a = new Admin();
			a.setPassword(pass);
			a.setUsername(username);
			adminService.saveAdmin(a);
			return "admin";
		}
		return "login";
	}

	@RequestMapping("/proizvodi")
	public String products(HttpServletRequest request, ModelMap model, @RequestParam (required = false) String vrsta){
		List<Slideshow> lista = slideshowService.findAll();
		model.addAttribute("slide", lista);
		if(request.getSession().getAttribute("admin")!=null){
			if(vrsta!=null&&!vrsta.equals("")&&!vrsta.equals("-1")){
				List<Proizvod> list = proizvodService.findByTip(vrsta);
				model.addAttribute("lista",list);
				model.addAttribute("tip",vrsta);
				return "products";
			}
			return "admin";
		}
		return "login";
	}
	@RequestMapping("/remove")
	public String remove (HttpServletRequest request,
	                  @RequestParam (value="checked", required = false) List<Integer> checked,
	                  ModelMap model){
		HttpSession session = request.getSession();
		List<Slideshow> lista = slideshowService.findAll();
		model.addAttribute("slide", lista);
		if(session.getAttribute("admin")!=null){
			if(checked!=null&&!checked.isEmpty()){
				for(Integer check:checked){
					Proizvod p = proizvodService.findById((long)check);
					proizvodService.delete((long)check);
					String filepath = request.getServletContext().getRealPath("resources/"+p.getProizvod());
					File file = new File(filepath+"/"+p.getSlika());
					file.delete();
					List<Proizvod> list = proizvodService.findByTip(p.getProizvod());
					model.addAttribute("lista",list);
					model.addAttribute("tip",p.getProizvod());
				}
			}
			return "products";
		}
		return "login";
	}
	
	@RequestMapping("/addslideshowpic")
	public String addSlideShowPic(@RequestParam (required = false)MultipartFile photo,
	                          HttpServletRequest request,
	                          ModelMap model) throws FileNotFoundException, IOException{
		HttpSession session = request.getSession();
		List<Slideshow> lista = slideshowService.findAll();
		model.addAttribute("slide", lista);
		if(session.getAttribute("admin")!=null){
			if(!photo.isEmpty()){    
				String filepath = request.getServletContext().getRealPath("resources/slideshow");
				FileOutputStream fos = new FileOutputStream(filepath+"/"+photo.getOriginalFilename());
				fos.write(photo.getBytes());
				fos.close();
				Slideshow slide = new Slideshow();
				slide.setSlika(photo.getOriginalFilename());
				slideshowService.save(slide);
			}
			return "admin";
		}
		return "login";
	}
	
	@RequestMapping("/slideshow")
	public String slideShowPic(HttpServletRequest request,ModelMap model){
		HttpSession session = request.getSession();
		if(session.getAttribute("admin")!=null){
			List<Slideshow> lista = slideshowService.findAll();
			model.addAttribute("slide", lista);
			model.addAttribute("slideshow", lista);
			return "products";
		}
		return "login";
	}
	
	@RequestMapping("/removeslideshowpic")
	public String removeSlideShowPic(HttpServletRequest request,ModelMap model,@RequestParam (value="checked", required = false) List<Integer> checked){
	HttpSession session = request.getSession();
	if(session.getAttribute("admin")!=null){
		
	    if(checked!=null&&!checked.isEmpty()){
	        for(Integer check:checked){
	            Slideshow slide = slideshowService.findById((long)check);
	            if(slide!=null){
	                slideshowService.delete((long)check);
	            }
	            String filepath = request.getServletContext().getRealPath("resources/slideshow");
	            File file = new File(filepath+"/"+slide.getSlika());
	            file.delete();
	        	}
	    	}
	    	List<Slideshow> lista = slideshowService.findAll();
	    	model.addAttribute("slide", lista);
	    	return "admin";
		}
		List<Slideshow> lista = slideshowService.findAll();
		model.addAttribute("slide", lista);
		return "login";
	}
	
	@RequestMapping("/izmena")
	public String izmenaAkcije(HttpServletRequest request,ModelMap model){
		HttpSession session = request.getSession();
		List<Slideshow> lista = slideshowService.findAll();
		model.addAttribute("slide", lista);
		if(session.getAttribute("admin")!=null){
			String path = request.getServletContext().getRealPath("resources/akcije");
			File dir = new File(path);
			for(File f:dir.listFiles()){
				f.delete();
			}
			return "izmenaakcije";
		}
		return "login";
	}
	
	@RequestMapping("/novaakcija")
	public String novaAkcije(HttpServletRequest request,
	                     ModelMap model,
	                     @RequestParam (required = false) MultipartFile photo) throws FileNotFoundException, IOException{
	HttpSession session = request.getSession();
	List<Slideshow> lista = slideshowService.findAll();
	model.addAttribute("slide", lista);
	if(session.getAttribute("admin")!=null){
	    if(!photo.isEmpty()){
	        String filepath = request.getServletContext().getRealPath("resources/akcije");
	        FileOutputStream fos = new FileOutputStream(filepath+"/"+photo.getOriginalFilename());
	        fos.write(photo.getBytes());
	        fos.close();
	    }
	    return "admin";
	}
	return "login";
	}
	
	@RequestMapping("/logout")
	public String logOut (HttpServletRequest request,ModelMap model){
		HttpSession session = request.getSession();
		List<Slideshow> lista = slideshowService.findAll();
		model.addAttribute("slide", lista);
		if(session.getAttribute("admin")!=null){
			session.removeAttribute("admin");
			return "index";
		}
		return "login";
	}
	
}
