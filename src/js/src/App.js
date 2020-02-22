import React, { useState, useEffect } from 'react';
import { getAllStudents } from './client';
import { Footer } from './Footer';

//takes response and grabs json inside of it
function App() {
    const [state, setState] = useState({students:[]});
    useEffect(() => {
        fetchStudents();
    }, [])
    function fetchStudents() {
        getAllStudents()
            .then(res => res.json())
            .then(students => {
                setState({
                    students: students
                }, ()=>{
                    console.log(state.students[0]['firstName']);
                });
                console.log(typeof students)
                // console.log(state.students[0]['firstName']);
            })
    }

    if (state.students && state.students.length){

        return (
            <div>
                <h1>Students</h1>
                        <Footer />
                <div>
                    {state.students.map((student) =>
                        <div>
                            <h2>{student.studentId}</h2>
                            <p>{student.firstName}</p>
                            <p>{student.secondName}</p>
                            <p>{student.gender}</p>
                            <p>{student.email}</p>
                        </div>
                    )}
                </div>
            </div>
        )
    }
        return ("No Students found")

}


export default App;