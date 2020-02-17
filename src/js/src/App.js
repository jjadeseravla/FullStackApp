import React, { useState, useEffect } from 'react';
import { getAllStudents } from './client';
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

    // if (students && students.length) {
    //   students.map((student, id) => {
    function displayLogic(){
        // for (let i = 0; i < state.students.length; i++) {
        //     toreturn.push(<h2><p>{state.students[i].firstName}</p></h2>);
        // }
        // });
        //
        // return toreturn;
    }
    if (state.students.length){
        return (
            <div>
                <h1>Students</h1>
                <div>
                    {state.students.map((student) =>
                        <h2><p>{student.firstName}
                        {student.secondName}</p></h2>
                    )}
                </div>
            </div>
        )
    }
    else{
        return ("No one")
    }
}
export default App;