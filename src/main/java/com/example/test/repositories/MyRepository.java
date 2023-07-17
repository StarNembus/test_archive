package com.example.test.repositories;

import com.example.test.entity.MyCounterEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MyRepository extends CrudRepository<MyCounterEntity, UUID> {
}
