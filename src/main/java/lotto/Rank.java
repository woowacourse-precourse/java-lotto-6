package lotto;

import java.util.function.BiFunction;

public enum Rank {
    FIRST(6, false, 2_000_000_000, (countWinningNum, bonusIsIn) -> countWinningNum == 6),
    SECOND(5, true, 30_000_000, (countWinningNum, bonusIsIn) -> countWinningNum == 5 && bonusIsIn),
    THIRD(5, false, 1_500_000, (countWinningNum, bonusIsIn) -> countWinningNum == 5 && !bonusIsIn),
    FOURTH(4, false, 50_000, (countWinningNum, bonusIsIn) -> countWinningNum == 4),
    FIFTH(3, false, 5_000, (countWinningNum, bonusIsIn) -> countWinningNum == 3),
    NONE(0, false, 0, (countWinningNum, bonusIsIn) -> countWinningNum <= 2);

    private final int countWinningNum;
    private final boolean bonusIsIn;
    private final int winnings;
    private final BiFunction<Integer, Boolean, Boolean> rankFunction;
    Rank(int countWinningNum, boolean bonusIsIn, int winnings, BiFunction<Integer, Boolean, Boolean> rankFunction) {
        this.countWinningNum = countWinningNum;
        this.bonusIsIn = bonusIsIn;
        this.winnings = winnings;
        this.rankFunction = rankFunction;
    }

    public boolean checkRank(int countWinningNum, boolean bonusIsIn) {
        return rankFunction.apply(countWinningNum, bonusIsIn);
    }

}
