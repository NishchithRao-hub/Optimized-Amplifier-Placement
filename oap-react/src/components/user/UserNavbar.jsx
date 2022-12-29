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
            <div class="container-fluid">
              <a class="navbar-brand" href="/">
                OAP
              </a>

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

              <div class="collapse navbar-collapse justify-content-center" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                  <Link to={`/user/${user}`} class="nav-link">
                    Your Profile
                  </Link>
                  <Link to="/network" class="nav-link">
                    Network
                  </Link>

                  <button onClick={handleLogout} class="btn btn-warning float-right nav-link logout">
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
