import React, { useEffect, useState } from 'react';
import axios from 'axios';

function StudentTable() {
    // State to hold the student data
    const [students, setStudents] = useState([]);
    const [error, setError] = useState(null);

    // Fetch students from the backend
    useEffect(() => {
        const fetchStudents = async () => {
            try {
                const response = await axios.get('http://localhost:8081/students/all');
                setStudents(response.data); // Update the state with fetched data
            } catch (err) {
                setError('Failed to fetch student data. Please try again later.');
                console.error(err);
            }
        };

        fetchStudents();
    }, []);

    return (
        <div>
            <h2>Student List</h2>
            {/* Show error message if there's an issue */}
            {error && <p style={{ color: 'red' }}>{error}</p>}
            {/* Show loading message if data is being fetched */}
            {!students.length && !error && <p>Loading...</p>}
            {/* Render student table */}
            {students.length > 0 && (
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Age</th>
                            <th>Grade</th>
                        </tr>
                    </thead>
                    <tbody>
                        {students.map((student) => (
                            <tr key={student.id}>
                                <td>{student.id}</td>
                                <td>{student.name}</td>
                                <td>{student.age}</td>
                                <td>{student.grade}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            )}
        </div>
    );
}

export default StudentTable;
