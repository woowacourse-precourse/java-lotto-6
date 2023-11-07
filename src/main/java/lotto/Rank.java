package lotto;

import java.util.List;

public enum Rank {
    MISS(0, 0, ""),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - "),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");

    private static final int WINNING_MIN_COUNT = 3;

    private final int matchCount;
    private final int prize;
    private final String message;

    Rank(int matchCount, int prize, String message) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.message = message;
    }

    public static Rank checkLotto(Lotto lotto, List<Integer> winningNumber, int bonusNumber){
        int matchWinningNumber = lotto.countMatch(winningNumber);
        boolean containBonus = lotto.containBonusNUmber(bonusNumber);
        return ranking(matchWinningNumber, containBonus);
    }

    private static Rank ranking(int matchWinningNumber, boolean containBonus){
        if (matchWinningNumber == SECOND.matchCount && containBonus){
            return SECOND;
        }
        for(Rank rank: values()){
            if (matchWinningNumber == rank.matchCount){
                return rank;
            }
        }
        return MISS;

    }




}
