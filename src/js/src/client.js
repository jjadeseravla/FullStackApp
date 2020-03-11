import fetch from 'unfetch';

const checkStatus = (response) => {
    if (response.ok) {
        return response;
    } else {
        let error = new Error(response.statusText);
        error.response = response;
        response.json().then(e => {
            error.error = e;
        });
        return Promise.reject(error);
    }
}

export const getAllStudents = () =>
    fetch('api/students') //fetch gives access to a promise
    .then(checkStatus);

export const addNewStudent = (student) =>
    fetch('api/students', {
        headers: {
            'Content-Type': 'application/json'
        },
        method: 'POST',
        body: JSON.stringify(student)
        //body: JSON.stringify({firstName: "David", secondName: "OLeary", email: "dol@gmail.com", gender:"MALE"})
    })
    .then(checkStatus);

export const deleteStudent = (studentId) =>
    fetch('api/students/${studentId}', {
        method: 'DELETE'
    })
    .then(checkStatus);
