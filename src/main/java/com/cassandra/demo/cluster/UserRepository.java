package com.cassandra.demo.cluster;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.cassandra.demo.model.User;

public interface UserRepository extends CassandraRepository<User, UUID> {
}
