package lotto.domain;

import java.text.DecimalFormat;

public enum Rank {
    FIFTH("3개 일치 ", 5000),
    FOURTH("4개 일치 ", 50000),
    THIRD("5개 일치 ", 1500000),
    SECOND("5개 일치, 보너스 볼 일치 ", 30000000),
    FIRST("6개 일치 ", 2000000000);

    private final String result;
    private final long reward;

    Rank(String result, long reward) {
        this.result = result;
        this.reward = reward;
    }

    public long getReward() {
        return reward;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String formattedAmount = decimalFormat.format(reward);
        return result + "(" + formattedAmount + "원)";
    }
}
