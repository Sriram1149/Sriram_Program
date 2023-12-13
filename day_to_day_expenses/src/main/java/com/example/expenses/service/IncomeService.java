package com.example.expenses.service;

import com.example.expenses.entities.Income;

public interface IncomeService {
	Income getIncomeById(int incometId );
	Income addIncome(Income income);
	Income updateDb(int incomeId, Income income);
	void deleteDb(int incomeId);

}
