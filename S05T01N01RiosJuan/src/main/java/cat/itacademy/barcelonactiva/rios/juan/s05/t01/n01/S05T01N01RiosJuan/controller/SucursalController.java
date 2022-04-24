package cat.itacademy.barcelonactiva.rios.juan.s05.t01.n01.S05T01N01RiosJuan.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cat.itacademy.barcelonactiva.rios.juan.s05.t01.n01.S05T01N01RiosJuan.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.rios.juan.s05.t01.n01.S05T01N01RiosJuan.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.rios.juan.s05.t01.n01.S05T01N01RiosJuan.service.SucusalService;


@Controller
public class SucursalController {
	
	@Autowired
	private SucusalService sucursalservice;
	
	@GetMapping("/sucursal/getAll")
	public String listar(Model model){
		
		List<Sucursal> s = new ArrayList<Sucursal>();
		List<SucursalDTO> s_dto = new ArrayList<SucursalDTO>();
		
		s=sucursalservice.Listar();	
		
		for(int i=0; i<s.size(); i++) {
			s_dto.add(new SucursalDTO(s.get(i)));
		}
		model.addAttribute("sucursales",s_dto);
		return "index";		
	}
	
	@GetMapping(value ="/sucursal/delete/{id}")
	public String eliminar(@PathVariable("id") int identif) {
		sucursalservice.eliminar(identif);
		return "redirect:http://localhost:9000/sucursal/getAll";		
	}
	
	@GetMapping("/sucursal/buscar/{id}")
	public String buscar(@PathVariable("id") int identif, Model model){
		
		Optional <Sucursal> s = null;
		s = sucursalservice.listarPorId(identif);
		if(!s.isEmpty()) {
			SucursalDTO s_dto = new SucursalDTO(s.get());
			model.addAttribute("sucursales",s_dto);
			return "index";	
		}
		else {
			return "error";
		}
			
	}
	
	 @GetMapping("/sucursal/add")
	 public String sucursal_nuevo(Model model) {
	        Sucursal sucursal = new Sucursal();
	        model.addAttribute("sucursal", sucursal);
	        return "nuevo";
	 }	
	
	@PostMapping("/saveSucursal")
    public String saveSucursal(@ModelAttribute("sucursal") Sucursal sucursal) {
        sucursalservice.Guardar(sucursal);
        return "redirect:http://localhost:9000/sucursal/getAll";
    }
	
	@GetMapping("/updateSucursal/{id}")
    public String updateSucursal(@PathVariable(value = "id") int id, Model model) {
        Optional <Sucursal> s = sucursalservice.listarPorId(id);
        model.addAttribute("sucursal", s);
        return "nuevo";
    }
	
}
