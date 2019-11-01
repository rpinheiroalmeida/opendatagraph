package com.unb.opendatagraph.repository;

import com.unb.opendatagraph.domain.CKAN;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CKANRepository extends Neo4jRepository<CKAN, Long> {

}
