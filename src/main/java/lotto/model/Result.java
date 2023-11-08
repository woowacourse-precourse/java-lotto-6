package lotto.model;

import java.util.ArrayList;
import java.util.List;

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
    public List<Result> calculateWinningResults(UserLotto userLotto, WinningLotto winningLotto) {
        List<Result> results = new ArrayList<>();
        for (Lotto lotto : userLotto.getUserLotto()) {
            int matchCount = countMatchNumbers(lotto, winningLotto);
            boolean hasBonus = lotto.contains(winningLotto.getBonusNumber());

            if (hasBonus) {
                matchCount++;
            }

            results.add(Result.of(matchCount, hasBonus));
        }
        return results;
    }

    private int countMatchNumbers(Lotto userLotto, WinningLotto winningLotto) {
        return (int) userLotto.getNumbers().stream()
                .filter(winningLotto::contains)
                .count();
    }

    public long countMatchingResults(List<Result> winningResults, Rank rank) {
        return winningResults.stream()
                .filter(result -> result.getRank() == rank)
                .count();
    }

}
