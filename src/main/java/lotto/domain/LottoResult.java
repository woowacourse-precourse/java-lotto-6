package lotto.domain;

import java.util.Arrays;

public enum LottoResult {
    FIRST_PLACE(1,6, 2000000000, "6개 일치 (2,000,000,000원)"),
    SECOND_PLACE(2, 5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD_PLACE(3, 5, 1500000, "5개 일치 (1,500,000원)"),
    FOURTH_PLACE(4, 4, 50000, "4개 일치 (50,000원)"),
    FIFTH_PLACE(5, 3, 5000, "3개 일치 (5,000원)"),
    OTHERS(6, 0, 0, null);

    private int grade;
    private int winningCount;
    private int profit;
    private String resultMessage;

    LottoResult(int grade, int winningCount, int profit, String resultMessage) {
        this.grade = grade;
        this.winningCount = winningCount;
        this.profit = profit;
        this.resultMessage = resultMessage;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public int getProfit() {
        return profit;
    }

    public static LottoResult of(int winningCount, boolean existBonusNumber) {
        if (winningCount == FIRST_PLACE.winningCount)
            return FIRST_PLACE;

        if (winningCount == SECOND_PLACE.winningCount) {
            if (existBonusNumber) return SECOND_PLACE;
            return THIRD_PLACE;
        }

        if (winningCount == FOURTH_PLACE.winningCount)
            return FOURTH_PLACE;

        if (winningCount == FIFTH_PLACE.winningCount)
            return FIFTH_PLACE;

        return OTHERS;
    }

    public static LottoResult of(int grade) {
        return Arrays.stream(values()).filter(l -> l.grade == grade).findAny().get();
    }
}
