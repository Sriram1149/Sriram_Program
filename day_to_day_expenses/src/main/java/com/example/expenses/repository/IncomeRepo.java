package com.example.expenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.expenses.entities.Income;

@Repository
public interface IncomeRepo extends JpaRepository<Income, Integer> {
	@Query(value =  "select * from Income where incomeId =?" , nativeQuery = true)
	Income findById(int incomeId);	
}
