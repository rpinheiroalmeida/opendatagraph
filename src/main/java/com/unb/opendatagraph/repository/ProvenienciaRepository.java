package com.unb.opendatagraph.repository;

import com.unb.opendatagraph.domain.Proveniencia;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvenienciaRepository extends Neo4jRepository<Proveniencia, Long> {

}
