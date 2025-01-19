import React from 'react';
import { Link } from 'react-router-dom';

function Sidebar() {
    return (
        <div style={{ padding: '10px', borderRight: '1px solid #ccc', height: '100vh' }}>
            <h3>Menu</h3>
            <ul style={{ listStyle: 'none', padding: 0 }}>
                <li><Link to="/">Home</Link></li>
                <li><Link to="/students">View Students</Link></li>
                <li><Link to="/add-student">Add Student</Link></li>
                <li><Link to="/update-student">Update Student</Link></li>
            </ul>
        </div>
    );
}

export default Sidebar;
