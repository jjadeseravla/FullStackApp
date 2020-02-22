import React, { useState, useEffect } from 'react';
import { getAllStudents } from './client';
import { Contents } from './Contents';

//takes response and grabs json inside of it
function App() {
    const [state, setState] = useState({students:[]});
    // const [handleAddStudentClickEvent, setHandleAddStudentClickEvent] = useState(false);
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
            })
    }

    // const toggle = () => setHandleAddStudentClickEvent(!handleAddStudentClickEvent);

    var numberOfStudents = state.students.length
    if (state.students && numberOfStudents){

        return (
            <div>
                <h1>Students</h1>
                {/*<Footer onClick={toggle} />*/}
                <Contents />
                {/*<Footer handleAddStudentClickEvent={handleAddStudentClickEvent} seeHandleAddStudentClickEvent={setHandleAddStudentClickEvent}/>*/}
                <h2>Number of Students: </h2>{numberOfStudents ? numberOfStudents : null}

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