package lotto;

import java.util.Arrays;

public enum Ranking {

    FIFTH(3, 5_000, false, "3개 일치 (5,000원)"),
    FOURTH(4, 50_000, false, "4개 일치 (50,000원)"),
    THIRD(5, 1_500_000, false, "5개 일치 (1,500,000원)"),
    SECOND(5, 30_000_000, true, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, 2_000_000_000, false, "6개 일치 (2,000,000,000원)"),
    FAIL(0, 0, false, "실패");

    private final int correctNumber;
    private final int reward;
    private final boolean hasBonusNumber;
    private final String description;

    Ranking(int correctNumber, int reward, boolean hasBonusNumber, String description) {
        this.correctNumber = correctNumber;
        this.reward = reward;
        this.hasBonusNumber = hasBonusNumber;
        this.description = description;
    }

    public static Ranking getRanking(int correctNumber, boolean hasBonusNumber) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.hasBonusNumber == hasBonusNumber && ranking.correctNumber == correctNumber)
                .findAny()
                .get();
    }

}
