package lotto.model;

public record WinningSummary(
        int numberOfMatches,
        boolean containsBonus,
        long prize,
        long frequency) {

    public static WinningSummary from(final LottoRank rank, final long frequency) {
        return new WinningSummary(
                rank.getNumberOfMatches(),
                rank.bonusMatches(),
                rank.getPrize(),
                frequency
        );
    }
}
