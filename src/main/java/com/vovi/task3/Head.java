package com.vovi.task3;

public class Head {
    private HeadState state;

    public Head(HeadState state) {
        this.state = state;
    }

    public HeadState getState() {
        return state;
    }

    public void setState(HeadState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Head{state=" + state + "}";
    }
}
