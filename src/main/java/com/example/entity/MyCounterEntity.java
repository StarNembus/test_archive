package com.example.entity;

import jakarta.persistence.Entity;

@Entity
public class MyCounterEntity {
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

    @Override
    public String toString() {
        return "MyCounterEntity{" +
                "myCounter=" + myCounter +
                '}';
    }
}
