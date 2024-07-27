import React, { useContext, useMemo } from 'react';
import ExpenseContext from '../context/ExpenseContext';
import '../styles/ExpenseList.css';

const ExpenseList = () => {

  const { expenses, categories } = useContext(ExpenseContext);

  const totalExpenses = useMemo(() => {
    return expenses.reduce((acc, expense) => acc + expense.amount, 0);
  }, [expenses]);

  const categoryBreakdown = useMemo(() => {
    const breakdown = {};
    expenses.forEach(expense => {
      breakdown[expense.category] = (breakdown[expense.category] || 0) + expense.amount;
    });
    return breakdown;
  }, [expenses]);

  return (
    <div className="expense-list">
      <h2>Total Expenses: {totalExpenses}</h2>
      <h3>Category Breakdown:</h3>
      <ul>
        {categories.map(category => (
          <li key={category}>
            {category}: {categoryBreakdown[category] || 0}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ExpenseList;
