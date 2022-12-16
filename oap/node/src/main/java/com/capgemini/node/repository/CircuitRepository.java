package com.capgemini.node.repository;

import com.capgemini.node.model.Circuit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CircuitRepository extends JpaRepository<Circuit, Integer> {
    Optional<Circuit> findBySource(String src);
    Optional<Circuit> findByDestination(String dest);

    Optional<Circuit> findBySourceAndDestination(String src, String dest);
}
