import React, { useState } from "react";
import { addNewStudent } from "./client";

function NewStudentForm() {
    const [firstName, setFirstName] = useState("");
    const [secondName, setSecondName] = useState("");
    const [email, setEmail] = useState("");
    const [gender, setGender] = useState("");

    const [data, setData] = React.useState(firstName, secondName, email, gender);

    const handleFormSubmit = event => {
        console.log(alert(JSON.stringify(data, null, 2)));
        event.preventDefault();
        setData({
            ...data,
            isSubmitting: true,
            errorMessage: null
        });

        console.log({firstName, secondName, email, gender})
        addNewStudent({firstName, secondName, email, gender}).then(() => {
            alert(JSON.stringify({
                firstName: data.firstName,
                secondName: data.secondName,
                email: data.email,
                gender: data.gender
            }))
        })
            .catch(error => {
                setData({
                    ...data,
                    isSubmitting: false,
                    errorMessage: error.message || error.statusText
                });
            });
    };

    return (
        <form onSubmit={handleFormSubmit}>
            <input
                value={data.firstName}
                onChange={e => setFirstName(e.target.value)}
                placeholder="First name"
                type="text"
                name="firstName"
                required
            />
            <input
                value={data.secondName}
                onChange={e => setSecondName(e.target.value)}
                placeholder="Second name"
                type="text"
                name="secondName"
                required
            />
            <input
                value={data.email}
                onChange={e => setEmail(e.target.value)}
                placeholder="Email address"
                type="email"
                name="email"
                required
            />
            <input
                value={data.gender}
                onChange={e => setGender(e.target.value)}
                placeholder="Gender. E.g Male or Female"
                type="gender"
                name="gender"
                required
            />
            <button type="submit" disabled={data.isSubmitting}>
                {data.isSubmitting ? (
                    "Loading..."
                ) : (
                    "Submit"
                )}
            </button>
        </form>
    );
}
 export default NewStudentForm;

