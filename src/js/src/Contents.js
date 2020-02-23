import React, {useState} from 'react';
import  NewStudentForm  from './NewStudentForm';

export function Contents() {

    const [handleAddStudentClickEvent, setHandleAddStudentClickEvent] = useState(false);

    const toggleAddStudentForm = () => setHandleAddStudentClickEvent(!handleAddStudentClickEvent);

    return (
    <div>
        <button onClick={toggleAddStudentForm}>
            Add new Student +
        </button>
        {handleAddStudentClickEvent ? <NewStudentForm/> : null}
    </div>
    )
};
