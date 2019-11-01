package com.unb.opendatagraph.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "Collection")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InformationSystems {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private String size;
	private String description;
	private String location;
	private String notes;

}
