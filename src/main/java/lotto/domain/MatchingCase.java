package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum MatchingCase {
    THREE_MATCHING(3, 5000),
    FOUR_MATCHING(4, 50000),
    FIVE_MATCHING(5, 1500000),
    FIVE_MATCHING_WITH_BONUS(5, 30000000),
    SIX_MATCHING(6, 2000000000),
    INIT(0, 0);

    private int matchingValue;
    private int prize;
    private int winningCount;

    MatchingCase(int matchingValue, int prize) {
        this.matchingValue = matchingValue;
        this.prize = prize;
        this.winningCount = 0;
    }

    public void initMathcingCase() {
        for (MatchingCase matchingCase:values()) {
            matchingCase.winningCount = 0;
        }
    }

    public int getMatchingValue() {
        return matchingValue;
    }

    public int getPrize() {
        return prize;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public void increaseSameCaseCount(int matchingCount, boolean bonusNumberMatching) {
        if (this == FIVE_MATCHING_WITH_BONUS && matchingCount == matchingValue && bonusNumberMatching ) {
            winningCount++;
        }
        if (this != FIVE_MATCHING_WITH_BONUS && matchingCount == matchingValue && !bonusNumberMatching ) {
            winningCount++;
        }
    }

    public List<MatchingCase> getValues() {
        return Arrays.stream(values())
                .filter(matchingCase -> matchingCase != INIT)
                .toList();
    }
}