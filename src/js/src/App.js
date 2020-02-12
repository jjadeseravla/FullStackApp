import React, { useState, useEffect } from 'react';
import './App.css';
import { getAllStudents } from './client';

//takes response and grabs json inside of it
function App() {

  const [state, setState] = useState([]);

  useEffect(() => {
    fetchStudents();
  }, [])

  function fetchStudents() {
     getAllStudents()
      .then(res => res.text()
      .then(students => {
        setState({
          students: students
        });
        console.log(students)
    }))
  }

  //this.students = this.students.bind(this)

  // const { students  = this.props}

  // if (students && students.length) {
  //   students.map((student, id) => {
      return (
      <div>
        <h1>Students</h1>
        {/*<div id={id}>*/}
        <div>
          <h2>
            <p>{state.students}</p>
            {/*<p>{student.firstName}</p>*/}
            {/*<p>{student.secondName}</p>*/}
            {/*<p>{student.gender}</p>*/}
            {/*<p>{student.email}</p>*/}
          </h2>
        </div>
      </div>
      )
}

export default App;
