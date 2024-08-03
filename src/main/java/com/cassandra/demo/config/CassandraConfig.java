package com.cassandra.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.datastax.oss.driver.api.core.CqlSession;

@Configuration
public class CassandraConfig {

    @Bean
    public CqlSession cqlSession() {

        return CqlSession.builder()
                .withLocalDatacenter("datacenter1")
                .withKeyspace("my_keyspace").withCodecRegistry(null)
                .build();
    }
}