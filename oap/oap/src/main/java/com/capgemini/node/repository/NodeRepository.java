package com.capgemini.node.repository;

import com.capgemini.node.model.Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NodeRepository extends JpaRepository<Node,Integer> {
    Optional<Node> findByNameIgnoreCase(String name);
}
