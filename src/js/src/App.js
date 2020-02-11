import React from 'react';
import './App.css';
import { getAllStudents } from './client';

//takes response and grabs json inside of it
function App() {

  getAllStudents()
      .then(res => res.text()
      .then(students => {
    console.log(students);
  }))

  return (
   <h1>hello world springboot and react</h1>
  )
}

export default App;
