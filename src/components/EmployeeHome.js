//import getUser from "../util/userSession";
import { Link, useNavigate } from 'react-router-dom'
import Sidebar from './Sidebar'

const EmployeeHome = () => {

    const navigate = useNavigate()

    //const localStor = JSON.parse(localStorage.getItem('user'))

    // handle click event of logout button
    const handleLogout = () => {
        //removeUserSession();
       // props.history.push('/');
       navigate('/');
        //localStorage.removeItem('user')
    }

    return (
        <div>

            <Sidebar />

            Welcome! <br /><br />

            <div>
                <Link to="/RegistrationForm">Register a Customer</Link>
            </div>

            <div>
                <Link to="/CustomerInfo">View Customers</Link>
            </div>

            <input type="button" onClick={handleLogout} value="Logout" />

        </div>
    );
}

export default EmployeeHome;