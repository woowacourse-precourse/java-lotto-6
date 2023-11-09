package lotto.model;

import static lotto.Message.ErrorMessage.OBJECT_IS_NULL;

import java.util.List;

public class Revenue {
    private double revenue = 0;

    public Revenue(List<List<Integer>> winningResultSources, int amount) {
        if (winningResultSources == null) {
            throw new NullPointerException(OBJECT_IS_NULL.getMessage());
        }
        calculateRevenue(winningResultSources, amount);
    }

    private void calculateRevenue(List<List<Integer>> winningResultSources, int amount) {
        for (List<Integer> winningResultSource : winningResultSources) {
            revenue += winningResultSource.stream().reduce(1, (a, b) -> a * b);
        }
        revenue = Math.round(((revenue / amount) * 100) * 10) / 10.0;
    }

    public double getRevenue() {
        return revenue;
    }
}
