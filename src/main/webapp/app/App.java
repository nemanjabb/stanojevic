package app;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
	public static void main (String[] args) throws IOException {
		SpringApplication.run(App.class, args);
//		File file = new File("src/main/webapp/WEB-INF/jsp/style.css");
//		String p = file.getAbsolutePath();
//		System.out.println(p);
//		BufferedReader br = new BufferedReader(new FileReader(file));
//		String s;
//		while((s=br.readLine())!=null) {
//			System.out.println(s);
//		}
	
	}
}
