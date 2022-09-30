import React from 'react';
import { slide as Menu } from 'react-burger-menu';

const Sidebar = () => {

  return (
    <Menu>
      <a className="menu-item" href="/EmployeeHome">
        Home
      </a>

      <a className="menu-item" href="/RegistrationForm">
        Register Customers
      </a>

      <a className="menu-item" href="/CustomerInfo">
        View Customers
      </a>

    </Menu>
  );
};

export default Sidebar