package com.unb.opendatagraph.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity(label = "Collection")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DW {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private String size;
	private String description;
	private String location;
	private String notes;

	@Relationship(type = "WasGeneratedBy")
	private ETL etlWasGeneratedBy;

	@Relationship(type = "WasDerivedFrom")
	private InformationSystems informationSystemsWasDerivedFrom;

}
