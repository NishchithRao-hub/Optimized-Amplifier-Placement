package com.capgemini.node.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Circuit {

    @Id
    @SequenceGenerator(name = "circuit_sequence",sequenceName ="circuit_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "circuit_sequence")
    private Integer circuit_id;

    private String source;
    private String destination;


}
