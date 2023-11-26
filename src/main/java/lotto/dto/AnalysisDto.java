package lotto.dto;

public record AnalysisDto(
        int threeMatched,
        int fourMatched,
        int fiveMatched,
        int fiveMatchedWithBonus,
        int sixMatched,
        double profitRate
) { }
