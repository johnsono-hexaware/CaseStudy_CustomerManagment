import React, { useState, useEffect } from "react";
import axios from "axios";
import Sidebar from "./Sidebar";

const CustomersListView = () => {
  const [customers, setCustomers] = useState([]);

  React.useEffect(() => {
    //  getBids().then(r => console.log(r));
    getCustomers();
  }, []);

  async function getCustomers() {
    //console.log(username+" is the user name correct here?");
    await axios({
      method: "get",
      url: "http://localhost:8080/viewcustomers",
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => {
        //console.log(response.data);
        let result = response.data;
        console.log(result);
        setCustomers(result);
        //setDep
        console.log(customers);
        //console.log(result);
      })
      .catch((error) => console.error(error));
  }

  useEffect(() => {
    console.log(customers);
    // console.log(dependents)
  }, [customers]);

  return (
    /* <div>
        <ul>
            {customers.map((data) => (
                <li key={data.customerId}> 
                    <p>{data.name}</p>
                    <p>{data.email}</p>
                    <p>{data.phonenumber}</p>
                    <p>{data.address}</p>
                </li>
            ))}
        </ul>
        </div>*/
    <div>
      <Sidebar />
      <h1>All Customers</h1>
      <ul className="CustomerList">
        {customers.map((cus) => (
          <li className="CustomerList-details">
            <p>{cus.name}</p>
            <p>{cus.email}</p>
            <h4>Dependents:</h4>
            <ul>
              {cus.dependents.map((dep) => (
                <li>
                  <p>Name: {dep.name}</p>
                  <p>Age: {dep.age}</p>
                </li>
              ))}
            </ul>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default CustomersListView;
