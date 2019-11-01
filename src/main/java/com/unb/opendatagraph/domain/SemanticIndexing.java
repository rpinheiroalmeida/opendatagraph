package com.unb.opendatagraph.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity(label = "Activity")
@Data
@NoArgsConstructor
public class SemanticIndexing {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private String Program;
	private String Version;
	private String Description;
	private String StartAtTime;
	private String EndAtTime;
	private String Software;
	private List<String> controledVocabulary;

	@Relationship(type = "WasAssociatedWith")
	private UnBGOLD unBGOLDWasAssociatedWith;

	@Relationship(type = "Used")
	private CSV csvUsed;
}
