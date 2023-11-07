package lotto.model;

import java.util.List;

import static lotto.Message.ErrorMessage.OBJECT_IS_NULL;

public class Revenue {
    private double revenue = 0;

    public Revenue(List<List<Integer>> winningResultSources, int amount) {
        if (winningResultSources == null) {
            throw new NullPointerException(OBJECT_IS_NULL.getMessage());
        }
        for (List<Integer> winningResultSource : winningResultSources) {
            revenue += winningResultSource.stream().reduce(1, (a, b) -> a * b);
        }
        revenue = Math.round(((revenue / amount) * 100) * 10) / 10.0;
    }

    public double getRevenue() {
        return revenue;
    }
}
