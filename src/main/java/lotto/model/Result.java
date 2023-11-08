package lotto.model;

public class Result {
    private final int matchCount;
    private final boolean hasBonus;


    public Result(int matchCount, boolean hasBonus) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isHasBonus() {
        return hasBonus;
    }

    public static Result of(int matchCount, boolean hasBonus) {
        return new Result(matchCount, hasBonus);
    }

    public Rank getRank() {
        int matchCount = this.matchCount;
        boolean hasBonus = this.hasBonus;

        if (matchCount == 6) { return Rank.FIRST;}
        if (matchCount == 5 && hasBonus) {return Rank.SECOND;}
        if (matchCount == 5) { return Rank.THIRD; }
        if (matchCount == 4) { return Rank.FOURTH; }
        if (matchCount == 3) { return Rank.FIFTH;}

        return Rank.NONE;
    }

    public int getPrize() {
        Rank rank = getRank();
        int prize = 0;

        if (rank == Rank.FIRST) { prize = Rank.FIRST.getReward(); }
        if (rank == Rank.SECOND) { prize = Rank.SECOND.getReward(); }
        if (rank == Rank.THIRD) { prize = Rank.THIRD.getReward(); }
        if (rank == Rank.FOURTH) { prize = Rank.FOURTH.getReward(); }
        if (rank == Rank.FIFTH) { prize = Rank.FIFTH.getReward(); }
        return prize;
    }

}
