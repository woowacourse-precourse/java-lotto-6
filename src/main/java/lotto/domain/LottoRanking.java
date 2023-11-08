package lotto.domain;

import java.text.DecimalFormat;
import java.util.Arrays;

public enum LottoRanking {
    FIFTH(3.0, 5000, "3개 일치"),
    FOURTH(4.0, 50000, "4개 일치"),
    THIRD(5.0, 1500000, "5개 일치"),
    SECOND(5.5, 30000000, "5개 일치, 보너스 볼 일치"),
    FIRST(6.0, 2000000000, "6개 일치");

    private final Double score;
    private final long prizeMoney;
    private final String condition;
    private final DecimalFormat prizeMoneyFormat = new DecimalFormat("#,###,###,###원");
    private int count = 0;

    LottoRanking(Double score, long prizeMoney, String condition) {
        this.score = score;
        this.prizeMoney = prizeMoney;
        this.condition = condition;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public int getCount() {
        return count;
    }

    public String getResult() {
        return condition + " (" + prizeMoneyFormat.format(prizeMoney) + ") - " + count + "개";
    }

    public static LottoRanking valueOfScore(Double score) {
        return Arrays.stream(values())
                .filter(value -> value.score.equals(score))
                .findAny()
                .orElse(null);
    }

    public void plusCount() {
        this.count++;
    }
}
