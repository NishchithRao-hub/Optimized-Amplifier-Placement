import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import { deleteCard, getCards } from "../../../services/NodeService";

function GetCards() {
  const [cards, setCards] = useState([]);

  useEffect(() => {
    getCards().then((res) => {
      setCards(res.data);
    });
  }, []);

  function handleDelete(id) {
    deleteCard(id).then((res) => {
      alert("Card with ID " + id + " has been deleted!");
    });
  }
  return (
    <>
      <h1>Cards</h1>
      <div class="vh-100">
        <div class="container ">
          <div class="table-responsive ">
            <table class="table table-bordered">
              <thead class="table-dark">
                <tr>
                  <th>Card ID</th>
                  <th>Card Name</th>
                  <th>Card Type</th>
                  <th>Update</th>
                  <th>Delete</th>
                </tr>
              </thead>
              <tbody>
                {cards.map((c) => (
                  <tr key={c.card_id}>
                    <td>{c.card_id}</td>
                    <td>{c.cardName}</td>
                    <td>{c.card_type}</td>
                    <td>
                      <Link to={`/card/update/${c.card_id}`}>Update</Link>
                    </td>
                    <td>
                      <button
                        className="btn btn-outline"
                        onClick={() => {
                          handleDelete(c.card_id);
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
          <Link to={"/card/add"}>Add a new Card</Link>
        </div>
      </div>
    </>
  );
}

export default GetCards;
