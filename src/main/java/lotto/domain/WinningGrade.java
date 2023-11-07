package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public enum WinningGrade {
    FIRST(1, 6, 2_000_000_000, false),
    SECOND(2, 5, 30_000_000, true),
    THIRD(3, 5, 1_500_000, false),
    FOURTH(4, 4, 50_000, false),
    FIFTH(5, 3, 5_000, false),
    DEFAULT(6, 0, 0, false);

    private final int grade;
    private final int matchCount;
    private final int prizeMoney;
    private final boolean bonusIncluded;

    WinningGrade(int grade, int matchCount, int prizeMoney, boolean bonusIncluded) {
        this.grade = grade;
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.bonusIncluded = bonusIncluded;
    }

    public static WinningGrade findGrade(int matchCount, boolean bonusIncluded) {
        if (matchCount == 5) {
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

    public static int getWinningAmount(EnumMap<WinningGrade, Integer> winningGradeMap) {
        return winningGradeMap.entrySet()
                .stream()
                .mapToInt(WinningGrade::calculatePrizeMoney)
                .sum();
    }

    private static int calculatePrizeMoney(Map.Entry<WinningGrade, Integer> grade) {
        return grade.getKey().prizeMoney * grade.getValue();
    }

}
