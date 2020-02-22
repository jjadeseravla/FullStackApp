import fetch from 'unfetch';

export const getAllStudents = () => fetch('api/students');

export const addNewStudent = (student) =>
    fetch('api/students', {
        headers: {
            'Content-Type': 'application/json'
        },
        method: 'POST',
        body: JSON.stringify(student)
});

//fetch("https://localhost:8080/api/students", {
//     method: "post",
//     headers: {
//         "Content-Type": "application/json"
//     },
//     body: JSON.stringify({
//         firstName: data.firstName,
//         secondName: data.secondName,
//         email: data.email,
//         gender: data.gender
//     })
// })