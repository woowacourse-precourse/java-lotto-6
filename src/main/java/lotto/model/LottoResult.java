package lotto.model;

import java.util.Arrays;
import java.util.Optional;

public enum LottoResult {
    THREE_MATCH(3, "5,000"),
    FOUR_MATCH(4, "50,000"),
    FIVE_MATCH(5, "1,500,000"),
    FIVE_MATCH_WITH_BONUS(5, "30,000,000"),
    SIX_MATCH(6, "2,000,000,000");

    private final int matchingNumbers;
    private final String prizeAmount;

    LottoResult(int matchingNumbers, String prizeAmount) {
        this.matchingNumbers = matchingNumbers;
        this.prizeAmount = prizeAmount;
    }

    public static Optional<LottoResult> create(int matchingNumbers, boolean bonusMatch) {
        if (matchingNumbers == 5 && bonusMatch) {
            return Optional.of(FIVE_MATCH_WITH_BONUS);
        }

        return Arrays.stream(values())
                .filter(l -> l.matchingNumbers == matchingNumbers)
                .findFirst();
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public String getPrizeAmount() {
        return prizeAmount;
    }
}