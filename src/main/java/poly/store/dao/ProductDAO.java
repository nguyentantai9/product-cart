package poly.store.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import poly.store.entity.Product;

@Service
public interface ProductDAO extends JpaRepository<Product, Integer>{

	@Query("SELECT p FROM Product p WHERE p.category.id=?1")
	List<Product> findCategoryId(String cid);
	
	@Query("SELECT p FROM Product p WHERE p.name=?1")
	List<Product> findName(String name);
	
	@Query("SELECT p.name FROM Product p")
	List<String> selectbox();
	
	/* @Query(value="SELECT * FROM Product WHERE name=?1",nativeQuery = true) */
}
