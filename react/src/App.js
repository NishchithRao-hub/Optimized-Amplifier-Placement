import logo from "./logo.svg";
import "./App.css";

import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import RegisterUser from "./components/user/register/RegisterUser";
import Home from "./components/Home";
import UserLogin from "./components/user/login/UserLogin";
import UserDashboard from "./components/user/UserDashboard";
import GetUser from "./components/user/GetUser";
import Network from "./components/Network";

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/user/register" element={<RegisterUser />} />
          <Route path="/user/login" element={<UserLogin />} />

          <Route path="/user/dashboard" element={<UserDashboard />} />
          <Route path="/user/:userName" element={<GetUser />} />
          <Route path="/network" element={<Network />} />a
        </Routes>
      </Router>
    </div>
  );
}

export default App;
