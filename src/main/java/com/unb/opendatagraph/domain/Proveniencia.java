package com.unb.opendatagraph.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Proveniencia {
	
	ExtractionSoftware extractionSoftware;
	UnBGOLD unbGOLD;
	ETL etl;
	DataRequest dataRequest;
	SemanticIndexing semanticIndexing;
	DataPublication dataPublication;
	InformationSystems informationSystems;
	DW dw;
	CSV csv;
	RDF rdf;
	CKAN ckan;
}
		 