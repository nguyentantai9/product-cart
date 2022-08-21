package poly.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import poly.store.entity.Product;

public interface ProductService  {

	List<Product> findAll();

	Product findById(Integer id);

	List<Product> findCategoryId(String cid);

	Product create(Product product);

	Product update(Product product);

	void delete(Integer id);

	List findName(String name);

	List select();
	
	








	
	

}
