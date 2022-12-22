package com.capgemini.node.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Link {

    @Id
    @SequenceGenerator(name = "link_sequence",sequenceName = "link_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "link_sequence")
    private Integer link_id;
    private String name;
    private int length;
    private String from_node;
    //from_edge
    private String to_node;
    //to_edge

    //forward_link
    //reverse_link

    public Link(String name, int length, String from_node, String to_node) {
        this.name = name;
        this.length = length;
        this.from_node = from_node;
        this.to_node = to_node;
    }
}
