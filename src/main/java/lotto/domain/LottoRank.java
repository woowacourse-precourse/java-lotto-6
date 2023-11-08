package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    MISS(0, false, 0),
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5,  false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    private static final int MATCH_COUNT_FIVE = 5;
    private final int match;
    private final boolean checkBonus;
    private final int prize;

    LottoRank(int match, boolean checkBonus, int prize){
        this.match = match;
        this.checkBonus = checkBonus;;
        this.prize = prize;
    }

    public static LottoRank valueOf(int match, boolean checkBonus){
        if(checkSecondRank(match,checkBonus)){
            return SECOND;
        }
        return findRankWithMatchPoint(match);
    }

    private static boolean checkSecondRank(int match, boolean checkBonus){
        return match == SECOND.match && checkBonus;
    }

    private static LottoRank findRankWithMatchPoint(int match){
        return Arrays.stream(values())
                .filter(Rank -> Rank.getMatch() == match)
                .findFirst()
                .orElse(MISS);
    }

    public int getMatch() {
        return match;
    }

    public boolean getCheckBonus() {
        return checkBonus;
    }

    public int getPrize() {
        return prize;
    }
}

