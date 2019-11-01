package com.unb.opendatagraph.repository;

import com.unb.opendatagraph.domain.DataRequest;
import com.unb.opendatagraph.domain.ETL;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRequestRepository extends Neo4jRepository<DataRequest, Long> {

}
