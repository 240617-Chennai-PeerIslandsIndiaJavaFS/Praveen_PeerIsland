import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import ExpenseForm from './components/ExpenseForm';
import ExpenseList from './components/ExpenseList';
import CategoryList from './components/CategoryList';
import { ExpenseProvider } from './context/ExpenseContext';
import './styles/App.css';
import './styles/Home.css';
import './styles/About.css';
import './styles/Contact.css';
import UsersDetails from './components/UsersDetails';

const App = () => {
  return (
    <ExpenseProvider>
      <Router>
        <div className="app-container">
          <h1>Expense Tracker App</h1>
          <nav className="nav-links">
            <Link to="/">Home</Link>
            <Link to="/about">About</Link>
            <Link to="/contact">Contact</Link>
          </nav>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/about" element={<About />} />
            <Route path="/contact" element={<Contact />} />
          </Routes>
        </div>
      </Router>
    </ExpenseProvider>
  );
};

const Home = () => (
  <div className="home-container">
    <ExpenseForm />
    <ExpenseList />
    <CategoryList />
  </div>
);

const About = () => (
  <div className="about-container">
    <h2>About Page</h2>
    <p>This is the about page of the Expense Tracker App. Here you can add more information about the application and its purpose.</p>
    <UsersDetails></UsersDetails>
  </div>
);

const Contact = () => (
  <div className="contact-container">
    <h2>Contact Page</h2>
    <p>This is the contact page of the Expense Tracker App. Here you can add contact information or a form for users to reach out.</p>
  </div>
);

export default App;
