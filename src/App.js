import './App.css';
import EmployeeLogin from './components/EmployeeLogin';
import EmployeeHome from './components/EmployeeHome';
import RegistrationForm from './components/RegistrationForm';
import CustomersListView from './components/CustomersListView'

import {
  BrowserRouter as Router,
  Route,
  Routes,
} from 'react-router-dom';

function App() {
  return (
    <Router>
    <div className="App">
      <Routes>
        <Route exact path="/" element={<EmployeeLogin/>} />
        <Route exact path="/EmployeeHome" element={<EmployeeHome/>} />
        <Route exact path="/RegistrationForm" element={<RegistrationForm/>} />
        <Route exact path="CustomerInfo" element={<CustomersListView/>} />
      </Routes>
    </div>
    
    </Router>
  );
}

export default App;
