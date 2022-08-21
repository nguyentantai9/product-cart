package poly.store.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import poly.store.entity.Product;
import poly.store.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {
	@Autowired
	ProductService productService;
	
	@GetMapping()
	public List<Product> getAll(){
		return productService.findAll();
	}
	@GetMapping("box")
	public List<Product> selectbox(){
		return productService.select();
	}
	
	@GetMapping("box/Select")
	public List<Product> selectitem(@RequestParam("name")String name){
		return productService.findName(name);
	}

	/* Cách 1 dùng biến cảu URL */
	@GetMapping("Search")
	public List<Product> findName1(@RequestParam("name")String name){
		return productService.findName(name);
	}
	/* Cách 1 dùng URI */
//	@GetMapping("/{name}")
//	public List<Product> findName2(@PathVariable("name")String name){
//		return productService.findName(name);
//	}
	
	@GetMapping("{id}")
	public Product getOne(@PathVariable("id")Integer id) {
		return productService.findById(id);
	}
	
	@PostMapping
	public Product create(@RequestBody Product product) {
		return productService.create(product);
	}
	
	@PutMapping("{id}")
	public Product update(@PathVariable("id")Integer id, @RequestBody Product product) {
		return productService.update(product);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id")Integer id) {
		productService.delete(id);
	}
	
}



















