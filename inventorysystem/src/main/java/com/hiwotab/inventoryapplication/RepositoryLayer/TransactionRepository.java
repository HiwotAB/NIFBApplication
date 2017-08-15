package com.hiwotab.inventoryapplication.RepositoryLayer;

import com.hiwotab.inventoryapplication.ModelLayer.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction,Long> {

}
