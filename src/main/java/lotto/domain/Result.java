package lotto.domain;

public class Result {
    private final Rank rank;

    public Result(int matCount, boolean bonusMatch) {
        this.rank = Rank.valueOf(matCount, bonusMatch);
    }

    public Rank getRank() {
        return rank;
    }

}
