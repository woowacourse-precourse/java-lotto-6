package lotto.model;

public class Result {
    private int count;

    public Result() {
        this.count = 0;
    }

    public void addCount() {
        this.count++;
    }

    public int getCount() {
        return this.count;
    }
}
