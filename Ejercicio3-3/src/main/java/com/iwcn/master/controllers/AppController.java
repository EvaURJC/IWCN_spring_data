package com.iwcn.master.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.iwcn.master.pro.Producto;
import com.iwcn.master.repositories.ProductoRepository;

@Controller
public class AppController {
	
	@Autowired
	private ProductoRepository productRepository;
	
	// Vista Principal
	@RequestMapping("/")
	public ModelAndView Principal() {
		return new ModelAndView("principal_template");
	}
	
	// Vista que contiene Lista de Productos
	@RequestMapping("/list")
    public ModelAndView listaProducto() {
		return new ModelAndView("list_template").addObject("prods", productRepository.selectAll());
    }
    
	// Vista que contiene el Formulario
    @RequestMapping("/new")
    public ModelAndView nuevoProducto(Model model, Producto pi) {
    	return new ModelAndView("newProduct_template");
    }
    
    // Vista que muestra que el producto se ha añadido
    @RequestMapping("/fin")
    public ModelAndView nuevoProducto2(Producto pi) {
    	productRepository.save(pi);
    	return new ModelAndView("fin_template").addObject("producto", pi.getNombre() + " ");
    }
    
    // Vista del producto en si
    @RequestMapping("/product/{optio}")
    public ModelAndView mostrarProducto(@PathVariable String optio) {
    	int index = Integer.parseInt(optio);
    	Producto p = productRepository.findById(index);
    	return new ModelAndView("product_template").addObject("nombre", p.getNombre()).addObject("codigo", 
    			p.getCodigo()).addObject("descripcion", p.getDescripcion()).addObject("precio", p.getPrecio());
    }
    
    // Vista que contiene Lista de Productos
    @RequestMapping("/borrar/{optio}")
    public ModelAndView borrarProducto(@PathVariable String optio) {
    	int index = Integer.parseInt(optio);
    	Producto p = productRepository.findById(index);
    	productRepository.delete(p);
    	return new ModelAndView("borrar_template").addObject("producto", p.getNombre());
    }
    
    //NUEVO
    
    // Vista que contiene el formulario para editar el producto
    @RequestMapping("/editar/{optio}")
    public ModelAndView editarProducto(@PathVariable String optio, Model model) {
    	int index = Integer.parseInt(optio);
    	Producto p = productRepository.findById(index);
    	model.addAttribute(p);
   	 	return new ModelAndView("editar_template").addObject("nombre", p.getNombre());
    }  
    
    // Vista que muestra que el producto se ha editado 
    @RequestMapping("/modificar")
    public ModelAndView modificarProducto(Producto pi) {
    	productRepository.setNewCodigo(pi.getCodigo(), pi.getId());
    	productRepository.setNewNombre(pi.getNombre(), pi.getId());
    	productRepository.setNewDescripcion(pi.getDescripcion(), pi.getId());
    	productRepository.setNewPrecio(pi.getPrecio(), pi.getId());
    	return new ModelAndView("modificar_template").addObject("nombre", pi.getNombre());
    }
    
}