package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum LottoRank {
    OUT_OF_RANK(0, "순위권 외", List.of()),
    FIFTH_PLACE(5000, "3개 일치 (5,000원)", List.of(List.of(3, 0), List.of(3, 1))),
    FOURTH_PLACE(50000, "4개 일치 (50,000원)", List.of(List.of(4, 0), List.of(4, 1))),
    THIRD_PLACE(1500000, "5개 일치 (1,500,000원)", List.of(List.of(5, 0))),
    SECOND_PLACE(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)", List.of(List.of(5, 1))),
    FIRST_PLACE(2000000000, "6개 일치 (2,000,000,000원)", List.of(List.of(6, 0), List.of(6, 1)));

    private final int value;
    private final String rankContent;
    private final List<List<Integer>> comparisonResult;

    LottoRank(int value, String rankContent, List<List<Integer>> comparisonResult) {
        this.value = value;
        this.rankContent = rankContent;
        this.comparisonResult = comparisonResult;
    }

    public int getValue() {
        return value;
    }

    public String getRankContent() {
        return rankContent;
    }

    public static LottoRank getRank(List<Integer> comparisonResult) {
        return Arrays.stream(LottoRank.values())
                .filter(compareResult -> compareResult.compare(comparisonResult))
                .findFirst()
                .orElse(OUT_OF_RANK);
    }

    private boolean compare(List<Integer> comparisonResult) {
        return this.comparisonResult.stream()
                .anyMatch(list -> list.equals(comparisonResult));
    }
}