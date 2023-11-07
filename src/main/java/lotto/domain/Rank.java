package lotto.domain;

import java.util.stream.Stream;

public enum Rank {
    FIFTH(3, 5000, "3개 일치", false),
    FOURTH(4, 50000, "4개 일치", false),
    THIRD(5, 1500000, "5개 일치", false),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치", true),
    FIRST(6, 2000000000, "6개 일치", false),
    NONE(-1, 0, "", false);

    private final int matchNumber;
    private final int prizeMoney;
    private final String explanation;
    private final boolean isCorrectBonusNumber;

    Rank(int matchNumber, int prizeMoney, String explanation, boolean isCorrectBonusNumber) {
        this.matchNumber = matchNumber;
        this.prizeMoney = prizeMoney;
        this.explanation = explanation;
        this.isCorrectBonusNumber = isCorrectBonusNumber;
    }

    public static Rank getRank(int matchNumber, boolean isCorrectBonusNumber) {
        return Stream.of(Rank.values())
                .filter(rank ->
                        rank.matchNumber == matchNumber
                                && rank.isCorrectBonusNumber == isCorrectBonusNumber)
                .findAny()
                .orElse(NONE);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getExplanation() {
        return explanation;
    }
}