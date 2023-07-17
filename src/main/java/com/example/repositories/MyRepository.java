package com.example.repositories;

import com.example.entity.MyCounterEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MyRepository extends CrudRepository<MyCounterEntity, UUID> {
}

