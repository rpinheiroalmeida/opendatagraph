package com.unb.opendatagraph.repository;

import com.unb.opendatagraph.domain.ExtractionSoftware;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtractSoftwareRepository extends Neo4jRepository<ExtractionSoftware, Long> {

}
