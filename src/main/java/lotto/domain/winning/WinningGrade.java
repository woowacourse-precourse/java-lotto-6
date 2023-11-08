package lotto.domain.winning;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;

public enum WinningGrade {
    DEFAULT(0,  0),
    FIFTH( 3, 5_000),
    FOURTH( 4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private static final int IS_SECOND_OR_THIRD = 5;
    private final int matchCount;
    private final int prizeMoney;

    WinningGrade(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static WinningGrade findGrade(int matchCount, boolean bonusIncluded) {
        if (matchCount == IS_SECOND_OR_THIRD) {
            return findSecondOrThirdGrade(bonusIncluded);
        }
        return findOthers(matchCount);
    }

    private static WinningGrade findOthers(int matchCount) {
        return Arrays.stream(WinningGrade.values())
                .filter(value -> value.matchCount == matchCount)
                .findFirst()
                .orElse(DEFAULT);
    }

    private static WinningGrade findSecondOrThirdGrade(boolean bonusIncluded) {
        if (bonusIncluded) {
            return SECOND;
        }
        return THIRD;
    }

    public static int getWinningAmount(Map<WinningGrade, Integer> winningGradeMap) {
        return winningGradeMap.entrySet()
                .stream()
                .mapToInt(WinningGrade::calculatePrizeMoney)
                .sum();
    }

    private static int calculatePrizeMoney(Map.Entry<WinningGrade, Integer> grade) {
        return getPrizeMoney(grade) * getWinningCount(grade);
    }

    private static Integer getWinningCount(Map.Entry<WinningGrade, Integer> grade) {
        return grade.getValue();
    }

    private static int getPrizeMoney(Map.Entry<WinningGrade, Integer> grade) {
        return grade.getKey().prizeMoney;
    }

    public boolean isSecondGrade() {
        return this == SECOND;
    }

    public String getPrizeMoney() {
        DecimalFormat thousandWonUit = new DecimalFormat("###,###");
        return thousandWonUit.format(this.prizeMoney);
    }

    public int getMatchCount() {
        return this.matchCount;
    }
}