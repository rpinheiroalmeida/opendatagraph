package com.unb.opendatagraph.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity(label = "Activity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ETL {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private String program;
	private String version;
	private String description;
	private String startAtTime;
	private String endAtTime;
	private String software;
	private String notes;

	@Relationship(type = "WasAssociatedWith")
	private ExtractionSoftware extractionSoftwareWasAssociatedWith;

	@Relationship(type = "Used")
	private InformationSystems informationSystemsUsed;

}
