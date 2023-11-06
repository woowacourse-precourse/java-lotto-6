package lotto.model;

import java.util.List;

public class Revenue {
    private double revenue;

    public Revenue(List<Integer> rawRevenue, int amount) {
        double revenue = (double) rawRevenue.stream()
                .reduce(1, (a, b) -> a * b) / amount;
    }

    public double getRevenue() {
        return revenue;
    }
}
