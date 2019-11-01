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
public class CSV {

	@GeneratedValue
	@Id
	private Long id;

	private String name;
	private String size;
	private String description;
	private String location;
	private String notes;

	@Relationship(type = "WasGeneratedBy")
	private DataRequest dataRequestWasGeneratedBy;

	@Relationship(type = "WasDerivedFrom")
	private DW dwWasDerivedFrom;
}
