package com.capgemini.node.service;

import com.capgemini.node.exception.CircuitException;
import com.capgemini.node.model.Circuit;
import com.capgemini.node.repository.CircuitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class CircuitServiceImpl implements CircuitService{

    public CircuitServiceImpl(){
    }

    private CircuitRepository circuitRepository;

    @Autowired
    public CircuitServiceImpl(CircuitRepository circuitRepository){
        this.circuitRepository = circuitRepository;
    }

    @Override
    public Circuit addCircuit(Circuit circuit) {
         circuitRepository.save(circuit);
         return circuit;
    }

    @Override
    public List<Circuit> getAllCircuits() {
        return circuitRepository.findAll();
    }

    @Override
    public Circuit getCircuitById(Integer id) {
        Optional<Circuit> circuit= circuitRepository.findById(id);
        if(circuit.isEmpty())
            throw new CircuitException("Invalid Circuit ID");
        return circuit.get();
    }

    @Override
    public Circuit getCircuitBySource(String src) {
        Optional<Circuit> circuit = circuitRepository.findBySource(src);
        if(circuit.isEmpty()){
            throw new CircuitException("Invalid Circuit Source");
        }
        return circuit.get();
    }

    @Override
    public Circuit getCircuitByDestination(String dest) {
        Optional<Circuit> circuit = circuitRepository.findByDestination(dest);
        if(circuit.isEmpty()){
            throw new CircuitException("Invalid Circuit Destination");
        }
        return circuit.get();
    }

    @Override
    public void deleteCircuit(Integer id) {
        Optional<Circuit> circuit= circuitRepository.findById(id);
        if (circuit.isEmpty())
            throw new CircuitException("Invalid Circuit ID");
        circuitRepository.deleteById(id);

    }

    @Override
    public Circuit updateCircuit(Integer id, Circuit circuit) {
        Optional<Circuit> circuit1 = circuitRepository.findById(id);
        if (circuit1.isEmpty())
            throw new CircuitException("Invalid Circuit ID");
        circuit1.get().setSource(circuit.getSource());
        circuit1.get().setDestination(circuit.getDestination());
        return circuit1.get();
    }
}
