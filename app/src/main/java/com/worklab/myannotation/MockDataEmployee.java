package com.worklab.myannotation;

/**
 * Created by skywander on 8/23/16.
 */
public class MockDataEmployee implements MockData{

    private String name;

    public MockDataEmployee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
