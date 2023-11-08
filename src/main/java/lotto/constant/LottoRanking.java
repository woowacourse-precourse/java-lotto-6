package lotto.constant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum LottoRanking {
    FIRST(6, 2000000000L),
    SECOND(5, 30000000L),
    THIRD(5, 1500000L),
    FOURTH(4, 50000L),
    FIFTH(3, 5000L);

    private final int sameCount;
    private final long prize;

    LottoRanking(int sameCount, long prize) {
        this.sameCount = sameCount;
        this.prize = prize;
    }

    public static LottoRanking convertLottoIntoLottoRanking(int count, boolean isBonusNumberCorrect) {
        return Arrays.stream(LottoRanking.values())
                .filter(lottoRanking -> isSatisfiedCondition(count, isBonusNumberCorrect, lottoRanking))
                .findFirst()
                .orElse(null);
    }

    private static boolean isSatisfiedCondition(int count, boolean isBonusNumberCorrect, LottoRanking lottoRanking) {
        if (count == 5 && isBonusNumberCorrect) {
            return lottoRanking.equals(SECOND);
        } else if (count == 5) {
            return lottoRanking.equals(THIRD);
        }
        return lottoRanking.getSameCount() == count;
    }

    public static Map<LottoRanking, Integer> convertValuesIntoCounters() {
        Map<LottoRanking, Integer> gameResults = new HashMap<>();
        Arrays.stream(LottoRanking.values())
                .forEach(lottoRanking -> gameResults.put(lottoRanking, 0));
        return gameResults;
    }

    public int getSameCount() {
        return sameCount;
    }

    public long getPrize() {
        return prize;
    }
}
