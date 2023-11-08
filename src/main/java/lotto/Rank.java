package lotto;

import java.util.Arrays;

public enum Rank {
    fifth(3, 0, 5000),
    fourth(4, 0, 50_000),
    third(5, 0, 1_500_000),
    second(5, 1, 30_000_000),
    first(6, 0, 2_000_000_000)
    ;

    int matches;
    int matchBonus;
    int price;
    Rank(int matches, int matchBonus, int price) {
        this.matches = matches;
        this.matchBonus = matchBonus;
        this.price = price;
    }

    public static Rank getRank(Lotto winningNumbers, Bonus bonus, Lotto lotto) {
        int matchCnt = (int) winningNumbers.getNumbers().stream()
                .filter(num -> lotto.getNumbers().contains(num))
                .count();

        int bonusCnt = 0;
        if(matchCnt == 5 && lotto.getNumbers().contains(bonus.getNumber())) {
            bonusCnt = 1;
        }

        int finalBonusCnt = bonusCnt;
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matches == matchCnt && rank.matchBonus == finalBonusCnt)
                .findAny().orElse(null);
    }
}
