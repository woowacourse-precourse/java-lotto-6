package lotto.model;

import java.text.DecimalFormat;
import java.util.List;

public class EarningRate {
    private final String earningRate;

    public EarningRate(double amount, List<Score> scores) {
        DecimalFormat decimalFormat = new DecimalFormat("###,##0.0%");
        earningRate = decimalFormat.format(calEarning(scores) / amount);
    }

    private int calEarning(List<Score> scores) {
        return scores.stream()
                .map(Score::getPrize)
                .reduce(Integer::sum)
                .get();
    }

    @Override
    public String toString() {
        return earningRate;
    }
}
