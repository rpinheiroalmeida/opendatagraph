package com.unb.opendatagraph.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "Agent")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExtractionSoftware  {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private String organization;
	private String description;
	private String operador;
	private String notes;

}
