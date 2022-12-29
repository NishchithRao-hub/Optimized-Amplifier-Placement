import { useCallback, useState, useEffect } from "react";
import { Link } from "react-router-dom";
import ReactFlow, {
  MiniMap,
  Controls,
  Background,
  useNodesState,
  useEdgesState,
  addEdge,
} from "reactflow";
import "reactflow/dist/style.css";
import "../../styles/Network.css";
import { getEdges, getLinks, getNodes } from "../../services/NodeService";
import AddNode from "./add/AddNode";
import AddLink from "./add/AddLink";

function Network() {
  const initialNodes = [
    {
      id: "1",
      position: { x: 0, y: 0 },
      data: { label: "1" },
      style: { height: 50, width: 50, borderRadius: 50 },
    },
    { id: "2", position: { x: 0, y: 100 }, data: { label: "2" } },
  ];

  const initialEdges = [{ id: "x", source: "1", target: "2" }];

  const [nodes, setNodes, onNodesChange] = useNodesState([]);
  const [edges, setEdges, onEdgesChange] = useEdgesState([]);

  useEffect(() => {
    getNodes().then((res) => {
      setNodes(
        res.data.map((n) => ({
          id: n.node_id.toString(),
          position: { x: n.xposition, y: n.yposition },
          data: { label: n.type },
          style: { height: 50, width: 50, borderRadius: 50 },
        }))
      );
    });
  }, [getNodes, setNodes]);

  useEffect(() => {
    getLinks().then((res) => {
      setEdges(
        res.data.map((l) => ({
          id: l.link_id.toString(),
          source: l.from_node,
          target: l.to_node,
        }))
      );
    });
  }, []);

  console.log(edges)

  // function add(ip, type, xp, yp) {
  //   nodes.push({
  //     id: ip,
  //     position: { x: xp, y: yp },
  //     data: { label: type },
  //     style: { height: 50, width: 50, borderRadius: 50 },
  //   });
  // }

  const onConnect = useCallback(
    (params) => setEdges((eds) => addEdge(params, eds)),
    [setEdges]
  );

  const [openModal, setOpenModal] = useState(false);

  return (
    <>
      <div style={{ width: "100%", height: "100vh" }}>
        <div className="network-nav">
          <button
            className="btn btn-outline openModalButton network-links"
            onClick={() => {
              setOpenModal(true);
            }}
          >
            Add Node
          </button>
          {openModal && <AddNode closeAddNode={setOpenModal} />}

          <Link className="network-links btn btn-outline" to={"/node/get"}>
            View Nodes
          </Link>
          <Link className="network-links btn btn-outline" to={"/edge/get"}>
            View Edges
          </Link>
          <Link className="network-links btn btn-outline" to={"/link/get"}>
            View Links
          </Link>
          <Link className="network-links btn btn-outline" to={"/card/get"}>
            View Cards
          </Link>
          <Link className="network-links btn btn-outline" to={"/circuit/get"}>
            View Circuits
          </Link>
          <Link className="network-links btn btn-outline" to={"/optimum"}>
            View Optimum Amplifier
          </Link>
        </div>
        <ReactFlow
          nodes={nodes}
          edges={edges}
          onNodesChange={onNodesChange}
          onEdgesChange={onEdgesChange}
          onConnect={onConnect}
        >
          <MiniMap />
          <Controls />
          <Background />
        </ReactFlow>
      </div>
    </>
  );
}

export default Network;
