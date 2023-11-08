package lotto.domain.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Receipt {
    private double rate;
    private final List<Integer> counts;

    public Receipt() {
        this.counts = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
    }

    public double getRate() {
        return rate;
    }

    public List<Integer> getCounts() {
        return counts;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
