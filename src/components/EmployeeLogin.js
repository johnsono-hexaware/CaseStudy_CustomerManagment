import React from 'react'
import axios from 'axios'
import { useNavigate } from 'react-router-dom';
import Welcome from './Welcome';
import { Alert } from 'react-alert'


const EmployeeLogin = () => {
    const username = React.useRef(null);
    const password = React.useRef(null);
    const navigate = useNavigate()

    const handleLogin = e => {
        e.preventDefault();

        const user = {
            id: username.current.value,
            password: password.current.value,
        }

        axios.post('http://localhost:8080/login', user)
            .then(response => {
                console.log(response.data)
                localStorage.setItem('user', JSON.stringify(response.data))
                navigate('/EmployeeHome')
            })
            .catch(error => {
                console.log(error)
                alert("Invalid Login Csredentials!")
            })
    };

    return (
        <div>
            <div><Welcome></Welcome></div>
            <div><h2>Login With Employee Credntials</h2></div>
            <div>
                <form onSubmit={handleLogin}>
                    <div><input type="text" placeholder="EmployeeID" ref={username} /></div>
                    <div><input type="password" placeholder="password" ref={password} /></div>
                    <button type="submit" className="myButton">Login</button>
                </form>
            </div>
            {/*<div>
                <h3>Not an Employee?</h3>
                <Link to="/ManagerLogin">Click to Login as Manager</Link>
    </div>*/}
        </div>
    );
}

export default EmployeeLogin