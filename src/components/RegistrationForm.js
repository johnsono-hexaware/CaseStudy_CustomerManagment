import React, { useState } from "react";
import DependentsForm from "./DependentsForm";
import axios from "axios";
import "../App.css";
import Sidebar from "./Sidebar";

function RegistrationForm() {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [phonenumber, setPhonenumber] = useState("");
  const [address, setAddress] = useState("");

  const handleSubmit = () => {
    const customer = {
      name: name,
      email: email,
      phonenumber: phonenumber,
      address: address,
    };

    const registration = {
      customer: customer,
      dependents: formFields,
    };

    axios
      .post("http://localhost:8080/register", registration)
      .then((response) => {
        console.log(response.data);
        //localStorage.setItem('user', JSON.stringify(response.data))
        //navigate('/EmployeeHome')
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const [formFields, setFormFields] = useState([{ name: null, age: null }]);

  const handleFormChange = (event, index) => {
    let data = [...formFields];
    data[index][event.target.name] = event.target.value;
    setFormFields(data);
  };

  const submit = (e) => {
    e.preventDefault();
    console.log(formFields);
  };

  const addFields = () => {
    let object = {
      name: null,
      age: null,
    };

    setFormFields([...formFields, object]);
  };

  const removeFields = (index) => {
    let data = [...formFields];
    data.splice(index, 1);
    setFormFields(data);
  };

  return (
    <div>
      <Sidebar />
      <div>
        <h2>Register A New Customer</h2>
      </div>
      <div>
        <form onSubmit={handleSubmit}>
          <div>
            <label>Name </label>
            <input
              type="text"
              placeholder="Full Name"
              onChange={(e) => setName(e.target.value)}
            />
          </div>
          <div>
            <label>Email</label>
            <input
              type="email"
              placeholder="example@domain.com"
              onChange={(e) => setEmail(e.target.value)}
            />
          </div>
          <div>
            <label>Phone Number</label> 
            <input
              type="tel"
              placeholder="###-###-####"
              onChange={(e) => setPhonenumber(e.target.value)}
            />
          </div>
          <div>
            <label>Address</label>
            <input
              type="text"
              placeholder="Full Address"
              onChange={(e) => setAddress(e.target.value)}
            />
          </div>

          <div className="App">
            Customer's dependents: (if any)
            {formFields.map((form, index) => {
              return (
                <div key={index}>
                  <label>Name</label>
                  <input
                    name="name"
                    placeholder="Name"
                    onChange={(event) => handleFormChange(event, index)}
                    value={form.name}
                  />
                  <label>Age</label>
                  <input
                    name="age"
                    placeholder="Age"
                    onChange={(event) => handleFormChange(event, index)}
                    value={form.age}
                  />
                  <button type="button" onClick={() => removeFields(index)}>
                    Remove
                  </button>
                </div>
              );
            })}

            <button type="button" onClick={addFields}>
              Add More..
            </button>
            <br />
          </div>
          <br></br>
          <button type="submit" className="myButton">
            Submit
          </button>
        </form>
      </div>
    </div>
  );
}

export default RegistrationForm;
