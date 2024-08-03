package com.cassandra.demo.model;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;

@Table("users")
@Data
public class User {
    @PrimaryKey
    private UUID id;

    @CassandraType(type = Name.TEXT)
    private String name;

}
