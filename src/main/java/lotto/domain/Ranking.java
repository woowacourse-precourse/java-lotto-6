package lotto.domain;

import java.util.Arrays;

public enum Ranking {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    ETC(0, false, 0);


    private final int winningNum;
    private final boolean hasBonus;
    private final int reward;

    Ranking( int winningNum, boolean hasBonus, int reward){
        this.winningNum = winningNum;
        this.hasBonus = hasBonus;
        this.reward = reward;
    }

    public static Ranking findByRanking(int winningNumber, boolean hasBonus){
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.hasRanking(winningNumber, hasBonus))
                .findAny()
                .orElse(Ranking.ETC);
    }

    public boolean hasRanking(int winningCount, boolean hasBonusNum){
        if(winningCount != 5) hasBonusNum = false;
        return this.winningNum == winningCount && this.hasBonus == hasBonusNum;
    }

    public int getReward(){
        return reward;
    }
}
