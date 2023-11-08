package lotto.model.domain;

import java.util.List;

public enum RankTable {
    THREE( 3, false, 5_000),
    FOUR(4, false, 50_000),
    FIVE(5, false,  1_500_000),
    BONUS(5, true,  30_000_000),
    SIX(6, false, 2_000_000_000);

    private final int matchNumber;
    private final boolean bonus;
    private final int money;

    RankTable(int matchNumber, boolean bonus, int money) {
        this.matchNumber = matchNumber;
        this.bonus = bonus;
        this.money = money;
    }

    public static RankTable filterBonusNumber(List<Integer> lottoNumber, int bonusNumber, int matchCount) {
        boolean bonus = lottoNumber.contains(bonusNumber);
        if (matchCount == 5 && bonus) {
            return BONUS;
        }
        if (matchCount >= 3 && !bonus) {
            return addMatchRank(matchCount);
        }
        return null;
    }

    private static RankTable addMatchRank(int matchCount) {
        RankTable matchVale = null;
        for (RankTable value : RankTable.values()) {
            if (value.getMatchNumber() == matchCount && !value.isBonus()) {
                matchVale = value;
            }
        }
        return matchVale;
    }


    public int getMatchNumber() {
        return matchNumber;
    }

    public boolean isBonus() {
        return bonus;
    }

    public int getMoney() {
        return money;
    }
}
