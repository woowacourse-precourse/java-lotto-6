package lotto.model;

public record WinningSummary(
        int numberOfMatches,
        boolean containsBonus,
        long prize,
        long count) {
}
