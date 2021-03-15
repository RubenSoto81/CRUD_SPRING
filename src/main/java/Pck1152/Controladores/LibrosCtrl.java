package Pck1152.Controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Pck1152.Entidades.Libros;
import Pck1152.Repositorios.LibrosCRUD;
import javax.validation.Valid;

@Controller
public class LibrosCtrl {

	@Autowired
    private LibrosCRUD lbc;
 
	// Listado de TODOS los registros
    @RequestMapping("/")
    public String listaLibros(ModelMap mp){
        mp.put("libros", lbc.findAll());
        return "lista";
    }
 
    // Va al formulario para insertar nuevo registro
    @GetMapping("/nuevo")
    public String nuevo(ModelMap mp){
        mp.put("libros", new Libros());
        return "nuevo";
    }
 
    // Recibe nuevo registro y lo guarda en BD
    @PostMapping("/crear")
    public String crear(@Valid Libros libros,
            BindingResult bindingResult, ModelMap mp){
        if(bindingResult.hasErrors()){
            return "/nuevo";
        }else{
            lbc.save(libros);
            mp.put("libros", libros);
            return "creado";
        }
    }
 
    // Vista del registro creado o actualizado
    @RequestMapping("/creado")
    public String creado(@RequestParam("libros") Libros libros){
        return "creado";
    }
 
    // Va al formulario para Actualizar registro con ID del registro
    @RequestMapping("/update/{id}")
    public String updateLibros(@PathVariable("id") Long id, ModelMap mp){
        mp.put("libros", lbc.findById(id));
        return "listaUpt";
    }
    
    // Recibe registro actualizado y lo guarda en BD
    @PostMapping("/update")
    public String update(@Valid Libros libros,
            BindingResult bindingResult, ModelMap mp){
        if(bindingResult.hasErrors()){
            return "error";  
        }else{
            lbc.save(libros);;
            mp.put("libros", libros);
            return "creado";
        }
    }
    
    // Borra registro por su ID 
    @RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id, Model model) {
		lbc.deleteById(id);
		return "borrado"; 
	}
    
    
}
