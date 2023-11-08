package lotto.util.enums;

import java.util.Arrays;
import java.util.Optional;

public enum LottoResult {
    MATCH_3("3개 일치 (5,000원)", 3, 5000),
    MATCH_4("4개 일치 (50,000원)", 4, 50000),
    MATCH_5("5개 일치 (1,500,000원)", 5, 1500000),
    MATCH_5_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원)", 5, 30000000),
    MATCH_6("6개 일치 (2,000,000,000원)", 6, 2000000000);

    private final String description;
    private final Integer matchCount;
    private final Integer prize;

    LottoResult(String description, Integer matchCount, Integer prize) {
        this.description = description;
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public String getDescription() {
        return description;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public static Optional<LottoResult> fromDescription(String description) {
        return Arrays.stream(LottoResult.values())
                .filter(result -> result.getDescription().equals(description))
                .findFirst();
    }

    public static Optional<String> fromMatchCount(Integer matchCount) {
        return Arrays.stream(LottoResult.values())
                .filter(result -> result.getMatchCount() == matchCount)
                .map(LottoResult::getDescription)
                .findFirst();
    }
}
