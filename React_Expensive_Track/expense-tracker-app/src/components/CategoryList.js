import React, { useContext } from 'react';
import ExpenseContext from '../context/ExpenseContext';
import '../styles/CategoryList.css';

const CategoryList = () => {
  
  const { categories } = useContext(ExpenseContext);

  return (
    <div className="category-list">
      <h2>Categories</h2>
      <ul>
        {categories.map(category => (
          <li key={category}>{category}</li>
        ))}
      </ul>
    </div>
  );
};

export default CategoryList;
