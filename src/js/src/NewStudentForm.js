import React, { useState } from "react";
function NewStudentForm() {
    const [firstName, setFirstName] = useState("");
    const [secondName, setSecondName] = useState("");
    const [email, setEmail] = useState("");
    const [gender, setGender] = useState("");

    // const onSubmit=({setSubmitting}) => {
    //     setTimeout(() => {
    //         alert(JSON.stringify(values, null, 2));
    //         setSubmitting(false);
    //     }, 400);
    // }

    return (
        <form>
            <input
                value={firstName}
                onChange={e => setFirstName(e.target.value)}
                placeholder="First name"
                type="text"
                name="firstName"
                required
            />
            <input
                value={secondName}
                onChange={e => setSecondName(e.target.value)}
                placeholder="Second name"
                type="text"
                name="secondName"
                required
            />
            <input
                value={email}
                onChange={e => setEmail(e.target.value)}
                placeholder="Email address"
                type="email"
                name="email"
                required
            />
            <input
                value={gender}
                onChange={e => setGender(e.target.value)}
                placeholder="Gender. E.g Male or Female"
                type="gender"
                name="gender"
                required
            />
            <button type="submit">Submit</button>
        </form>
    );
}
 export default NewStudentForm;


// import React from 'react';
//
// export function NewStudentForm() {
//
//     return (
//         <div>
//             <h2>Add New Student</h2>
//
//             <button onClick={onCancel}>Cancel</button>
//             <button onClick={onOk}>OK</button>
//         </div>
//     )
// };
