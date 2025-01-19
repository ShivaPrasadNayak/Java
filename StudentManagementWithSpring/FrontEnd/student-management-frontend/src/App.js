import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Sidebar from './layout/Sidebar';
import Home from './pages/Home';
import Students from './pages/Students';
import AddStudent from './components/AddStudent';
import UpdateStudent from './components/UpdateStudent';

function App() {
    return (
        <Router>
            <div style={{ display: 'flex' }}>
                <Sidebar />
                <div style={{ flex: 1, padding: '10px' }}>
                    <Routes>
                        <Route path="/" element={<Home />} />
                        <Route path="/students" element={<Students />} />
                        <Route path="/add-student" element={<AddStudent />} />
                        <Route path="/update-student" element={<UpdateStudent />} />
                    </Routes>
                </div>
            </div>
        </Router>
    );
}

export default App;
