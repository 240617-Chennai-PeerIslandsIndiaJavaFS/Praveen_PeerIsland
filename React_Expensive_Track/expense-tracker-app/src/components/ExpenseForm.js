import React, { useContext, useRef } from 'react';
import ExpenseContext from '../context/ExpenseContext';
import '../styles/ExpenseForm.css';

const ExpenseForm = () => {
  const { setExpenses, setCategories } = useContext(ExpenseContext);
  const titleRef = useRef();
  const amountRef = useRef();
  const categoryRef = useRef();

  const handleAddExpense = () => {
    const newExpense = {
      title: titleRef.current.value,
      amount: parseFloat(amountRef.current.value),
      category: categoryRef.current.value,
    };
    setExpenses(prevExpenses => [...prevExpenses, newExpense]);
  };

  const handleAddCategory = () => {
    const newCategory = categoryRef.current.value;
    setCategories(prevCategories => [...prevCategories, newCategory]);
  };

  return (
    <div className="expense-form">
      <h2>Add Expense</h2>
      <input type="text" placeholder="Title" ref={titleRef} />
      <input type="number" placeholder="Amount" ref={amountRef} />
      <input type="text" placeholder="Category" ref={categoryRef} />
      <button onClick={handleAddExpense}>Add Expense</button>
      <button onClick={handleAddCategory}>Add Category</button>
    </div>
  );
};

export default ExpenseForm;
