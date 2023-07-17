package com.example.test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class MyCounterEntity {
    @Id
    private UUID id = UUID.randomUUID();


    private int myCounter;

    public MyCounterEntity() {
    }

    public MyCounterEntity(int myCounter) {
        this.myCounter = myCounter;
    }

    public int getMyCounter() {
        return myCounter;
    }

    public void setMyCounter(int myCounter) {
        this.myCounter = myCounter;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MyCounterEntity{" +
                "id=" + id +
                ", myCounter=" + myCounter +
                '}';
    }

}
