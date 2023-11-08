package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Arrays;
import java.util.Map;
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

    private int countOfSameNumber;
    private long prize;
    private BiPredicate<Integer, Boolean> rankDeterminer;

    WinningDetails (int countOfSameNumber, long prize, BiPredicate<Integer, Boolean> rankDeterminer) {
        this.countOfSameNumber = countOfSameNumber;
        this.prize = prize;
        this.rankDeterminer = rankDeterminer;
    }

    public static WinningDetails getRank(final int matchCount, Boolean containBonusNumber) {
        return Arrays.stream(WinningDetails.values())
                .filter(rank -> rank.rankDeterminer.test(matchCount, containBonusNumber))
                .findAny()
                .orElse(MISS);
    }
}

public class Calculate {
    private List<Lotto> lottos;
    private List<Integer> answer;
    private int bonus;
    private final Map<WinningDetails, Integer> rankResult;

    public Calculate(List<Lotto> lottos, List<Integer> answer, int bonus) {
        rankResult = new EnumMap<WinningDetails, Integer>(WinningDetails.class);
        this.lottos = lottos;
        this.answer = answer;
        this.bonus = bonus;
    }

    private void initMap() {
        Arrays.stream(WinningDetails.values())
                .forEach(rank -> rankResult.put(rank, 0));
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
            WinningDetails rank = WinningDetails.getRank(cnt, containBonus(lottos.get(i).getLotto()));
            updateRank(rank);
        }
    }

    private void updateRank(WinningDetails rank) {
        int number = rankResult.get(rank);
        rankResult.put(rank, number + 1);
    }

    public boolean containBonus(List<Integer> lotto) {
        return lotto.contains(bonus);
    }

    public int[] getRank() {
        return rank;
    }
}
