import React, {useState} from 'react';
import  NewStudentForm  from './NewStudentForm';

export function Contents() {

    const [handleAddStudentClickEvent, setHandleAddStudentClickEvent] = useState(false);

    const toggleTrueFalse = () => setHandleAddStudentClickEvent(!handleAddStudentClickEvent);

    return (
    <div>
        <button onClick={toggleTrueFalse}>
            Add new Student +
        </button>
        {handleAddStudentClickEvent ? <NewStudentForm/> : null}
    </div>
    )
};
