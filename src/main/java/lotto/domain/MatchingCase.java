package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum MatchingCase {
    THREE_MATCHING(3, 5000),
    FOUR_MATCHING(4, 50000),
    FIVE_MATCHING(5, 1500000),
    FIVE_MATCHING_WITH_BONUS(5, 30000000),
    SIX_MATCHING(6, 2000000000),
    NEW_GAME(0, 0);

    private int matchingValue;
    private int prize;
    private int winningCount;

    MatchingCase(int matchingValue, int prize) {
        this.matchingValue = matchingValue;
        this.prize = prize;
        this.winningCount = 0;
    }

    public void initMatchingCase() {
        for (MatchingCase matchingCase : values()) {
            matchingCase.winningCount = 0;
        }
    }

    public void recordResult(int matchingCount, boolean bonusNumberMatching) {
        if (matchesFiveWithBonus(matchingCount, bonusNumberMatching)) {
            winningCount++;
        }
        if (matches(matchingCount, bonusNumberMatching)) {
            winningCount++;
        }
    }

    private boolean matchesFiveWithBonus(int matchingCount, boolean bonusNumberMatching) {
        return this == FIVE_MATCHING_WITH_BONUS && bonusNumberMatching && matchingCount == matchingValue;
    }

    private boolean matches(int matchingCount, boolean bonusNumberMatching) {
        return this != FIVE_MATCHING_WITH_BONUS && !bonusNumberMatching && matchingCount == matchingValue;
    }

    public int calculatePrize() {
        return prize * winningCount;
    }

    public List<MatchingCase> getResult() {
        return Arrays.stream(values())
                .filter(matchingCase -> matchingCase != NEW_GAME)
                .toList();
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
}