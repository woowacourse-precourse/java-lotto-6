package lotto.model;

import static lotto.util.GameConstant.*;

public class Result {
    private int count;

    protected Result() {
        this.count = CONSTANT_INITIAL_VALUE.getConstant();
    }

    protected void addCount() {
        this.count++;
    }

    protected int getCount() {
        return this.count;
    }
}
