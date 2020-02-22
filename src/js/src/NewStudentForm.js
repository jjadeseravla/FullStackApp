import React, { useState } from "react";
import { addNewStudent } from "./client";

function NewStudentForm() {
    const [firstName, setFirstName] = useState("");
    const [secondName, setSecondName] = useState("");
    const [email, setEmail] = useState("");
    const [gender, setGender] = useState("");

    // const onSubmit={(value, {setSubmitting}) => {
    //     setTimeout(() => {
    //         alert(JSON.stringify(value, null, 2));
    //         setSubmitting(false);
    //     }, 400);
    // }}

    const [data, setData] = React.useState(firstName, secondName, email, gender);
    // const handleInputChange = event => {
    //     setData({
    //         ...data,
    //         [event.target.name]: event.target.value
    //     });
    // };
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

        // fetch("https://localhost:8080/api/students", {
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
        //     .then(res => {
        //         if (res.ok) {
        //             return res.json();
        //         }
        //         throw res;
        //     })


            // .then(resJson => {
            //     dispatch({
            //         type: "LOGIN",
            //         payload: resJson
            //     })
            // })

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
                // value={firstName}
                value={data.firstName}
                onChange={e => setFirstName(e.target.value)}
                //onChange={handleInputChange}
                placeholder="First name"
                type="text"
                name="firstName"
                required
            />
            <input
                // value={secondName}
                value={data.secondName}
                onChange={e => setSecondName(e.target.value)}
                //onChange={handleInputChange}
                placeholder="Second name"
                type="text"
                name="secondName"
                required
            />
            <input
                // value={email}
                value={data.email}
                onChange={e => setEmail(e.target.value)}
                // onChange={handleInputChange}
                placeholder="Email address"
                type="email"
                name="email"
                required
            />
            <input
                // value={gender}
                value={data.gender}
                onChange={e => setGender(e.target.value)}
                //onChange={handleInputChange}
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

