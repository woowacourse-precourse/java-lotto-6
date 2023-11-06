package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum LottoRank {
    FIRST_PLACE("1위", List.of(List.of(6, 0), List.of(6, 1))),
    SECOND_PLACE("2위", List.of(List.of(5, 1))),
    THIRD_PLACE("3위", List.of(List.of(5, 0))),
    FOURTH_PLACE("4위", List.of(List.of(4, 0), List.of(4, 1))),
    FIFTH_PLACE("5위", List.of(List.of(3, 0), List.of(3, 1))),
    OUT_OF_RANK("순위권 외", List.of());

    private final String rankContent;
    private final List<List<Integer>> comparisonResult;

    LottoRank(String rankContent, List<List<Integer>> comparisonResult) {
        this.rankContent = rankContent;
        this.comparisonResult = comparisonResult;
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