package lotto.model;

public class Result {
    private int count;

    protected Result() {
        this.count = 0;
    }

    protected void addCount() {
        this.count++;
    }

    protected int getCount() {
        return this.count;
    }
}
