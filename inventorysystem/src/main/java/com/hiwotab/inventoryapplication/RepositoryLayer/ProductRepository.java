package com.hiwotab.inventoryapplication.RepositoryLayer;

import com.hiwotab.inventoryapplication.ModelLayer.Product;
import com.hiwotab.inventoryapplication.ModelLayer.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {
    Iterable<Product>findAllByProdCode(String prodCode);

}
