import React from "react";
import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";

function UserNavbar() {
  const user = JSON.parse(localStorage.getItem("loggedInUser"));

  const navigate = useNavigate();

  const handleLogout = () => {
    if (user !== null) {
      localStorage.removeItem("loggedInUser");
      alert(user + " has been logged out!");
      navigate("/");
    }
  };
  return (
    <div>
      {user !== null ? (
        <div>
          <nav class="navbar navbar-expand-md navbar-light bg-light">
            <div class="container-fluid" >
              <button
                class="navbar-toggler"
                type="button"
                data-mdb-toggle="collapse"
                data-mdb-target="#navbarNavAltMarkup"
                aria-controls="navbarNavAltMarkup"
                aria-expanded="false"
                aria-label="Toggle navigation"
              >
                <i class="fas fa-bars"></i>
              </button>

              {console.log(user)}
              <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                  <Link to={`/user/${user}`} class="nav-link">
                    Your Profile
                  </Link>
                  <Link to="/network" class="nav-link">
                    Network
                  </Link>
                  
                  <button onClick={handleLogout} class="float-right nav-link">
                    Logout
                  </button>
                </div>
              </div>
            </div>
          </nav>
        </div>
      ) : (
        <h2>Please Login first!</h2>
      )}
    </div>
  );
}

export default UserNavbar;
