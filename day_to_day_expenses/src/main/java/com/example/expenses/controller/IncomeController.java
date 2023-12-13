package com.example.expenses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.expenses.entities.Income;
import com.example.expenses.service.IncomeService;

@RestController
public class IncomeController {
	@Autowired
	IncomeService incomeServices;
		
		@GetMapping("/income/{Id}")
		public Income getIncomeById(@PathVariable int incomeId) {
			return incomeServices.getIncomeById(incomeId); 
		}
		
		@PostMapping("/addincome")
		public Income addIncome(@RequestBody Income income) {
			
			return incomeServices.addIncome(income);
		}
		
		@PutMapping("/updateincome")
		public Income update(@RequestHeader int incomeId ,@RequestBody Income income) {
			
			return incomeServices.updateDb( incomeId ,income); 
		}
		@DeleteMapping("/deleteincome")
		public String delete(@RequestHeader int incomeId ) {
			incomeServices.deleteDb(incomeId );
			return "data deleted";
		}
		
		
	}

