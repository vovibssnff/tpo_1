package com.vovi.task3;

public class TwoHeadedPerson extends Person {
    private Head leftHead;
    private Head rightHead;

    public TwoHeadedPerson(String name, Head leftHead, Head rightHead) {
        super(name);
        this.leftHead = leftHead;
        this.rightHead = rightHead;
    }

    public Head getLeftHead() {
        return leftHead;
    }

    public void setLeftHead(Head leftHead) {
        this.leftHead = leftHead;
    }

    public Head getRightHead() {
        return rightHead;
    }

    public void setRightHead(Head rightHead) {
        this.rightHead = rightHead;
    }

    @Override
    public String toString() {
        return "TwoHeadedPerson{" +
                "name='" + getName() + '\'' +
                ", leftHead=" + leftHead +
                ", rightHead=" + rightHead +
                '}';
    }
}
