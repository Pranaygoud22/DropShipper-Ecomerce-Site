package com.Pranay.Ecom.Proj.Repository;

import com.Pranay.Ecom.Proj.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query("SELECT p FROM Product p WHERE " + "LOWER(p.name) LIKE LOWER(CONCAT('%', :Keyword,'%')) OR "
    + "LOWER(p.brand) LIKE LOWER(CONCAT('%', :Keyword,'%')) OR "
    + "LOWER(p.description) LIKE LOWER(CONCAT('%', :Keyword,'%')) OR "
    + "LOWER(p.category) LIKE LOWER(CONCAT('%', :Keyword,'%'))")
    List<Product> searchKeyword(String Keyword);
}
