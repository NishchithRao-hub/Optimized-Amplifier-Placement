package com.capgemini.node.service;

import com.capgemini.node.model.Circuit;

import java.util.List;

public interface CircuitService {
    public Circuit addCircuit(Circuit circuit);
    public List<Circuit> getAllCircuits();
    public Circuit getCircuitById(Integer id);
    public Circuit getCircuitBySource(String src);
    public Circuit getCircuitByDestination(String dest);
    public void deleteCircuit(Integer id);
    public Circuit updateCircuit(Integer id, Circuit circuit);
}
