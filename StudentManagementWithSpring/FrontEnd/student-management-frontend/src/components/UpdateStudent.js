import React, { useState } from 'react';
import axios from 'axios';

function UpdateStudent() {
    const [formData, setFormData] = useState({ id: '', name: '', age: '', grade: '' });

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleUpdate = async () => {
        try {
            await axios.put(`http://localhost:8081/students/update/${formData.id}`, formData);
            alert('Student updated successfully!');
            setFormData({ id: '', name: '', age: '', grade: '' });
        } catch (error) {
            console.error('Error updating student:', error);
        }
    };

    return (
        <div>
            <h2>Update Student</h2>
            <div>
                <label>ID: <input type="text" name="id" value={formData.id} onChange={handleInputChange} /></label>
            </div>
            <div>
                <label>Name: <input type="text" name="name" value={formData.name} onChange={handleInputChange} /></label>
            </div>
            <div>
                <label>Age: <input type="number" name="age" value={formData.age} onChange={handleInputChange} /></label>
            </div>
            <div>
                <label>Grade: <input type="text" name="grade" value={formData.grade} onChange={handleInputChange} /></label>
            </div>
            <button onClick={handleUpdate}>Update Student</button>
        </div>
    );
}

export default UpdateStudent;
