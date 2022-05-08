package cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.rios.juan.s05.t02.n01.S05T02N01RiosJuan.seguridad.dto.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class UserController {
		

	@PostMapping("user")
	public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
		User user = new User(username,pwd);
		if(comprobar(username, pwd)) {
			String token = getJWTToken(username);
			user.setUser(username);
			user.setToken(token);	
			return user;
		}		
			return user;	
	}
	
	private boolean comprobar(String name, String password) {
		
		List<String> usuario = new ArrayList<String>();
		List<List<String>>listaUsuarios = new ArrayList<List<String>>();
		usuario.add("juan");
		usuario.add("123");
		listaUsuarios.add(usuario);
		usuario = new ArrayList<String>();
		usuario.add("pedro");
		usuario.add("123");
		listaUsuarios.add(usuario);
		System.out.println("name: "+ name + " "+ "password: "+ password);
		for(int i=0; i<listaUsuarios.size(); i++) {
			if(listaUsuarios.get(i).get(0).equals(name) && listaUsuarios.get(i).get(1).equals(password))
			{
				return true;
			}			
		}
		return false;
		
		
	}

	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER, ROLE_ADMIN");
		System.out.println("grantedAuthorities:"+ grantedAuthorities.get(1));
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();
		
		
		return "Bearer " + token;
	}
}
