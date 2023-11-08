package lotto.domain;

import java.util.Arrays;

public enum Result {

    THREE_SAME(3, 5000, "3개 일치"),
    FOUR_SAME(4, 50000, "4개 일치"),
    FIVE_SAME(5, 1500000, "5개 일치"),
    FIVE_AND_BONUS_SAME(5, 30000000, "5개 일치, 보너스 볼 일치"),
    SIX_SAME(6, 2000000000, "6개 일치"),
    NO_SAME(0, 0, "당첨되지 않음");

    final int sameNumber;
    final long reward;
    final String mention;

    Result(int sameNumber, int reward, String mention) {
        this.sameNumber = sameNumber;
        this.reward = reward;
        this.mention = mention;
    }

    public long getReward() {
        return this.reward;
    }

    public String getMention() {
        return this.mention;
    }


    public static Result resultOf(int sameNumber, boolean isBonus) {
        Result result = findMatchNumber(sameNumber);

        if (result == FIVE_SAME) {
            if (isBonus) {
                return FIVE_AND_BONUS_SAME;
            }
            return FIVE_SAME;
        }
        return result;
    }

    private static Result findMatchNumber(int sameNumber) {
        return Arrays.stream(values())
                .filter(result -> result.sameNumber == sameNumber)
                .findFirst()
                .orElse(NO_SAME);
    }
}
