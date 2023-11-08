package lotto;

import java.util.List;

public enum Prize {
    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5) {
        @Override
        public int numberOfWins(List<Lotto> lottos, Lotto winning, int bonus) {
            int count = 0;
            for (Lotto lotto : lottos) {
                if (winning.matches(lotto) == SECOND.matchNumber && winning.matches(bonus)) {
                    count++;
                }
            }
            return count;
        }
    },
    THIRD(1500_000, 5),
    FOURTH(50_000, 4),
    FIFTH(5_000, 3);
    private long prizeMoney;
    private int matchNumber;

    private Prize(long prizeMoney, int matchNumber) {
        this.prizeMoney = prizeMoney;
        this.matchNumber = matchNumber;
    }

    public int numberOfWins(List<Lotto> lottos, Lotto winning, int bonus) {
        int count = 0;
        for (Lotto lotto : lottos) {
            if (winning.matches(lotto) == matchNumber) {
                count++;
            }
        }
        return count;
    }

}
