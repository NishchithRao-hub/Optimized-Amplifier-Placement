import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { deleteCircuit, getCircuits } from "../../../services/NodeService";

function GetCircuits() {
  const [ciruits, setCircuits] = useState([]);

  useEffect(() => {
    getCircuits().then((res) => {
      setCircuits(res.data);
    });
  }, []);

  function handleDelete(id) {
    deleteCircuit(id).then((res) => {
      alert("Circuit with ID " + id + " has been deleted!");
    });
  }

  return (
    <>
      <h1>Circuits</h1>
      <div class="vh-100">
        <div class="container ">
          <div class="table-responsive ">
            <table class="table table-bordered">
              <thead class="table-dark">
                <tr>
                  <th>Circuit ID</th>
                  <th>Source</th>
                  <th>Destination</th>
                  <th>Update</th>
                  <th>Delete</th>
                </tr>
              </thead>
              <tbody>
                {ciruits.map((c) => (
                  <tr key={c.circuit_id}>
                    <td>{c.circuit_id}</td>
                    <td>{c.source}</td>
                    <td>{c.destination}</td>
                    <td>
                      <Link to={`/circuit/update/${c.circuit_id}`}>Update</Link>
                    </td>
                    <td>
                      <button
                        className="btn btn-outline"
                        onClick={() => {
                          handleDelete(c.circuit_id);
                        }}
                      >
                        🗑️
                      </button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
          <Link to={"/circuit/add"}>Add a new Circuit</Link>
        </div>
      </div>
    </>
  );
}

export default GetCircuits;
