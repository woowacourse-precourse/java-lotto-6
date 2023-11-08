package lotto.model.domain;

import java.util.ArrayList;
import java.util.List;

public enum RankTable {
    THREE(3, false, 5_000),
    FOUR(4, false, 50_000),
    FIVE(5, false, 1_500_000),
    BONUS(5, true, 30_000_000),
    SIX(6, false, 2_000_000_000);

    private final int matchNumber;
    private final boolean bonus;
    private final int money;

    RankTable(int matchNumber, boolean bonus, int money) {
        this.matchNumber = matchNumber;
        this.bonus = bonus;
        this.money = money;
    }

    public static List<RankTable> filterBonusNumber(List<Lotto> lottos, int bonusNumber, List<Integer> matchCounts) {
        List<RankTable> rankTables = new ArrayList<>();
        for (int i = 0; i < lottos.size(); i++) {
            boolean bonus = lottos.get(i).getNumbers().contains(bonusNumber);
            Integer matchCount = matchCounts.get(i);

            if (matchCount == BONUS.getMatchNumber() && bonus) {
                rankTables.add(BONUS);
            }
            if (matchCount >= THREE.getMatchNumber() && !bonus) {
                rankTables.add(addMatchRank(matchCount));
            }
        }
        return rankTables;
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
