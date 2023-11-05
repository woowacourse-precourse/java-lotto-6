package lotto.model;

import java.util.Arrays;

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

    public static LottoResult create(int matchingNumbers, boolean bonusMatch) {
        if (matchingNumbers == 5 && bonusMatch) {
            return FIVE_MATCH_WITH_BONUS;
        }

        return Arrays.stream(values())
                .filter(l -> l.matchingNumbers == matchingNumbers)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] : 당첨된 로또가 한개도 없습니다."));
    }
}