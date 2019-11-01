package com.unb.opendatagraph.repository;

import com.unb.opendatagraph.domain.ETL;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ETLRepository extends Neo4jRepository<ETL, Long> {

}
