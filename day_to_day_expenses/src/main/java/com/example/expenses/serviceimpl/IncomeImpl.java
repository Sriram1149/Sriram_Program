package com.example.expenses.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expenses.entities.Income;
import com.example.expenses.expectation.ResourceNotFoundException;
import com.example.expenses.repository.IncomeRepo;
import com.example.expenses.service.IncomeService;

@Service
public class IncomeImpl implements IncomeService {

	@Autowired
	IncomeRepo incomeRepo;
	
	@Override
	public Income getIncomeById(int incomeId ) {
		Optional<Income> pay=Optional.ofNullable(incomeRepo.findById(incomeId));

		Income p;
		if(pay.isPresent())
       {

			 p=pay.get();

		}

else {

			throw new ResourceNotFoundException();

		}

		return p;

}

	@Override
	public Income addIncome(Income income) {
		return  incomeRepo.save(income);
	}

	@Override
	public Income updateDb(int incomeId, Income income) {
	Income s1 = incomeRepo.findById(incomeId);
		
		if(s1!=null) {
			s1.setAmount(income.getAmount());   
			s1.setComments(income.getComments());
			s1.setIncomeId(income.getIncomeId());
		return incomeRepo.save(s1);
		} 
		else 
		{
			throw new ResourceNotFoundException();
		} 
	}

	@Override
	public void deleteDb(int incomeId) {
	
		
		Income s2 = incomeRepo.findById(incomeId);

		if(s2!=null) {
			incomeRepo.delete(s2);
		}
		else {
			throw new ResourceNotFoundException();
		}		 
	

	
	
}

}
