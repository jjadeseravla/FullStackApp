import React, {useState} from 'react';
import { NewComponent } from './NewComponent';

export function Footer() {

    const [handleAddStudentClickEvent, setHandleAddStudentClickEvent] = useState(false);

    const toggleTrueFalse = () => setHandleAddStudentClickEvent(!handleAddStudentClickEvent);

    return (
    <div>
        <button onClick={toggleTrueFalse}>
            Add new Student +
        </button>
        {handleAddStudentClickEvent ? <NewComponent/> : null}
    </div>
    )
};
