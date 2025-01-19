import React, { useState } from 'react';
import axios from 'axios';

function AddStudent() {
    const [formData, setFormData] = useState({ name: '', age: '', grade: '' });

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleAdd = async () => {
        try {
            await axios.post('http://localhost:8081/students/add', formData);
            alert('Student added successfully!');
            setFormData({ name: '', age: '', grade: '' });
        } catch (error) {
            console.error('Error adding student:', error);
        }
    };

    return (
        <div>
            <h2>Add Student</h2>
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
            <button onClick={handleAdd}>Add Student</button>
        </div>
    );
}

export default AddStudent;
