package lotto;

import java.util.List;
import java.util.Arrays;
import java.util.function.BiPredicate;

enum WinningDetails {
    FIRST(3, 5_000,
            (matchCount, isBonusNumberMatch) -> matchCount == 3),
    SECOND(4, 50_000,
            (matchCount, isBonusNumberMatch) -> matchCount == 4),
    THIRD(5, 1_500_000,
            (matchCount, isBonusNumberMatch) -> matchCount == 5 && !isBonusNumberMatch),
    FOURTH(5, 30_000_000,
            (matchCount, isBonusNumberMatch) -> matchCount == 5 && isBonusNumberMatch),
    FIFTH(6, 2_000_000_000,
            (matchCount, isBonusNumberMatch) -> matchCount == 6),
    MISS(0, 0,
            (matchCount, isBonusNumberMatch) -> matchCount < 3);

    private int matchCount;
    private long prize;
    private BiPredicate<Integer, Boolean> matchingPrize;

    WinningDetails (int matchCount, long prize, BiPredicate<Integer, Boolean> matchingPrize) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.matchingPrize = matchingPrize;
    }

    public WinningDetails getRank(final int matchCount, Boolean containBonusNumber) {
        return Arrays.stream(WinningDetails.values())
                .filter(rank -> rank.matchingPrize.test(matchCount, containBonusNumber))
                .findAny()
                .orElse(MISS);
    }
}

public class Calculate {
    private List<Lotto> lottos;
    private List<Integer> answer;
    private int bonus;
    private int[] rank = new int[7];

    public Calculate(List<Lotto> lottos, List<Integer> answer, int bonus) {
        this.lottos = lottos;
        this.answer = answer;
        this.bonus = bonus;
    }

    private int count(List<Integer> lotto) {
        int count = 0;
        for (Integer integer : answer) {
            if (lotto.contains(integer)) {
                count += 1;
            }
        }
        return count;
    }

    public void countAll() {
        for (int i = 0; i < lottos.size(); i++) {
            int cnt = count(lottos.get(i).getLotto());
            if (cnt == 6) rank[1] += 1;
            else if (cnt == 5) {
                rank[containBonus(lottos.get(i).getLotto())] += 1;
            }
            else if (cnt == 4) rank[4] += 1;
            else if (cnt == 3) rank[5] += 1;
            else if (cnt < 3) rank[0] += 1;
        }
    }

    public int containBonus(List<Integer> lotto) {
        if (lotto.contains(bonus)) {
            return 2;
        }
        return 3;
    }

    public int[] getRank() {
        return rank;
    }
}
