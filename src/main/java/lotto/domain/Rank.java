package lotto.domain;

import java.util.Arrays;

public enum Rank {
    RANK_1("6개 일치 (2,000,000,000원) - ", 2000000000, 6, false),
    RANK_2("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000, 6, true),
    RANK_3("5개 일치 (1,500,000원) - ", 1500000, 5, false),
    RANK_4("4개 일치 (50,000원) - ", 50000, 4, false),
    RANK_5("3개 일치 (5,000원) - ", 5000, 3, false),
    UNRANK(null, null, null, null);

    private final String outputMessage;
    private final Integer prize;

    // 맞은 번호 개수
    private final Integer matchCount;

    // 맞은 번호 개수에 보너스 포함 여부
    // true 이면 matchCount에 보너스 번호도 포함하여 계산
    private final Boolean isMatchCountIncludeBonus;

    Rank(String outputMessage, Integer prize, Integer matchCount, Boolean isMatchCountIncludeBonus) {
        this.outputMessage = outputMessage;
        this.prize = prize;
        this.matchCount = matchCount;
        this.isMatchCountIncludeBonus = isMatchCountIncludeBonus;
    }

    public static Rank getRank(Integer matchCount, Boolean isMatchBonus) {
        try {
            validate(matchCount, isMatchBonus);
        } catch (IllegalArgumentException e) {
            return UNRANK;
        }

        return Arrays.stream(Rank.values())
                .filter(rank -> rank != UNRANK)
                .filter(rank -> {
                    if (rank.isMatchCountIncludeBonus && isMatchBonus) {
                        return rank.matchCount.equals(matchCount + 1);
                    }
                    return rank.matchCount.equals(matchCount);
                })
                .findFirst()
                .orElse(UNRANK);
    }

    private static void validate(Integer matchCount, Boolean isMatchBonus) throws IllegalArgumentException {
        if (matchCount < 0 || matchCount > 6) {
            throw new IllegalArgumentException();
        }

        if (isMatchBonus && matchCount + 1 > 6) {
            throw new IllegalArgumentException();
        }
    }

    public String getOutputMessage() {
        return this.outputMessage;
    }

    public Integer getPrize() {
        return prize;
    }
}