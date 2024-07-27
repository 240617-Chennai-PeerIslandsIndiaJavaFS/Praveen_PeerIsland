import React, { createContext, useState, useEffect } from 'react';

const ExpenseContext = createContext();

export const ExpenseProvider = ({ children }) => {
  const [expenses, setExpenses] = useState([]);
  const [categories, setCategories] = useState([]);

  useEffect(() => {
    const storedExpenses = JSON.parse(localStorage.getItem('expenses'));
    const storedCategories = JSON.parse(localStorage.getItem('categories'));

    if (storedExpenses){
      setExpenses(storedExpenses);
    } 
    if (storedCategories) {
      setCategories(storedCategories);
    }
  }, []);

  useEffect(() => {
    localStorage.setItem('expenses', JSON.stringify(expenses));
    localStorage.setItem('categories', JSON.stringify(categories));
  }, [expenses, categories]);

  return (
    <ExpenseContext.Provider value={{ expenses, setExpenses, categories, setCategories }}>
      {children}
    </ExpenseContext.Provider>
  );
};

export default ExpenseContext;
