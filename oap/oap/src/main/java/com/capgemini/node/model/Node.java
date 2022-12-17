package com.capgemini.node.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Node {
    @Id
    @SequenceGenerator(name = "node_sequence",sequenceName = "node_sequence")
    @GeneratedValue(strategy = SEQUENCE,generator = "node_sequence")
    private Integer node_id;
    private String name;
    private String ip;
    private String password;
    private String type;
    private Integer xPosition;
    private Integer yPosition;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Edge> edges = new ArrayList<>();

    public Node(String name, String ip, String password, String type, List<Edge> edges) {
        this.name = name;
        this.ip = ip;
        this.password = password;
        this.type = type;
        this.edges = edges;
    }

//    public void addEdge(Edge edge){
//        this.edges.add(edge);
//        edge.setNode(this);
//    }
}
