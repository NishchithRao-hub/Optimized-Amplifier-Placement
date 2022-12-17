package com.capgemini.node.service;

import com.capgemini.node.model.Edge;

import java.util.List;

public interface EdgeService {
    public Edge addEdge(Edge edge);
    public List<Edge> getAllEdges();
    public Edge getEdgeById(Integer id);
    public Edge getEdgeByName(Character name);
    public void deleteEdge(Integer id);
    public Edge updateEdge(Integer id, Edge edge);
}
