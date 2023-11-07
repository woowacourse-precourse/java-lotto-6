package lotto.domain;

import java.util.List;

public enum Ranking {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0,false,0);

    private final int matchNumber;
    private final boolean isBonusMatched;
    private final int prize;

    Ranking(int matchNumber, boolean isBonusMatched, int prize) {
        this.matchNumber = matchNumber;
        this.isBonusMatched = isBonusMatched;
        this.prize = prize;
    }

    public long compareLottoNumbers(List<Integer> lotto, List<Integer> winningNumbers){
        return lotto.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean compareBonusNumber(List<Integer> lotto, int bonusNumber){
        for(int number: lotto){
            if(number == bonusNumber)
                return true;
        }
        return false;
    }

    public static Ranking determineRanking(long matchCount, boolean isBonus) {
        for (Ranking ranking : Ranking.values()) {
            if (matchCount == 5 && isBonus) {
                return SECOND;
            }
            if(ranking.matchNumber == matchCount){
                return ranking;
            }
        }
        return NONE;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public boolean isBonusMatched() {
        return isBonusMatched;
    }

    public int getPrize() {
        return prize;
    }
}
