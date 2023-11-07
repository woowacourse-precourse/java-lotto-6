package lotto.model;

public class MatchScore {
    private final Ranking ranking;

    public MatchScore(int matchLottoScore, int matchBonusScore) {
        ranking = Ranking.getRanking(matchLottoScore, matchBonusScore);
    }

    public Ranking getRanking() {
        return this.ranking;
    }
}
