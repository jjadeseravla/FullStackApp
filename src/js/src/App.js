import React, {useState, useEffect} from 'react';
import {getAllStudents} from './client';
import {Contents} from './Contents';
import {DeleteStudent} from './DeleteStudent';

//takes response and grabs json inside of it
function App() {
    const [state, setState] = useState({students: []});
    useEffect(() => {
        fetchStudents();
    }, [])

    function fetchStudents() {
        getAllStudents()
            .then(res => res.json())
            .then(students => {
                setState({
                    students: students
                }, () => {
                    console.log(state.students[0]['firstName']);
                })
                console.log(typeof students)
            })
            .catch(error => {
                console.log(error.error.message);
                setState({
                    students: []
                });
            });
    }

    var numberOfStudents = state.students.length
    if (state.students && numberOfStudents) {

        return (
            <div>
                <h1>Studentsss</h1>
                <Contents />
                <h2>Number of Students: </h2>{numberOfStudents ? numberOfStudents : null}

                <div>
                    {state.students.map((student, index) =>
                        <div key={index}>
                            <h2>{student.studentId}</h2>
                            <p>{student.firstName}</p>
                            <p>{student.secondName}</p>
                            <p>{student.gender}</p>
                            <p>{student.email}</p>
                            {/*<button onClick={<DeleteStudent />}>Delete Student</button>*/}
                        </div>
                    )}
                </div>
            </div>
        )
    }
    return (
        <div>
            <Contents/>
            No Students found
        </div>
    )

}


export default App;