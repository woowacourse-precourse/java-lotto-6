package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<Rank, Integer> result = new EnumMap<>(Rank.class);

    public LottoResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            Rank rank = calculateRank(lotto, winningNumbers, bonusNumber);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
    }

    private Rank calculateRank(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = (int) lotto.getNumbers().stream()
                                    .filter(winningNumbers::contains)
                                    .count();
        boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
        return Rank.valueOf(matchCount, bonusMatch);
    }

    public long getTotalPrize() {
        return result.entrySet().stream()
                     .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                     .sum();
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }
}

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final long prize;

    Rank(int matchCount, long prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Rank valueOf(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && bonusMatch) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return NONE;
    }

    public long getPrize() {
        return prize;
    }
}