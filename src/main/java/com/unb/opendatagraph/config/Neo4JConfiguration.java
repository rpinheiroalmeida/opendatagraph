package com.unb.opendatagraph.config;

import org.neo4j.ogm.config.Configuration.Builder;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@ComponentScan("com.unb.opendatagraph.domain")
@EnableNeo4jRepositories(basePackages = "com.unb.opendatagraph.repository")
public class Neo4JConfiguration {

    @Value("${spring.data.neo4j.uri}")
    private String databaseUrl;

    @Value("${spring.data.neo4j.username}")
    private String userName;

    @Value("${spring.data.neo4j.password}")
    private String password;

    @Bean
    public org.neo4j.ogm.config.Configuration getConfiguration() {
        org.neo4j.ogm.config.Configuration config = new Builder()
                .uri(databaseUrl)
                .credentials(userName, password)
                .build();
        return config;
    }


    @Bean
    public SessionFactory sessionFactory() {
        return new SessionFactory(getConfiguration(), "com.unb.opendatagraph.domain");
    }
}
