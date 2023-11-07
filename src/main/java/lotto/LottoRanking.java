package lotto;

import java.util.HashMap;
import java.util.List;
import lotto.util.StringUtil;

public enum LottoRanking {
    FIRST_PRIZE("6개 일치 (2,000,000,000원) - ", new Amount("2000000000")),
    SECOND_PRIZE("5개 일치, 보너스 볼 일치 (30,000,000원) - ", new Amount("30000000")),
    THIRD_PRIZE("5개 일치 (1,500,000원) - ", new Amount("1500000")),
    FOURTH_PRIZE("4개 일치 (50,000원) - ", new Amount("50000")),
    FIFTH_PRIZE("3개 일치 (5,000원) - ", new Amount("5000")),
    DID_NOT_WIN("", new Amount("0"));

    private static final int ADD_ONE = 1;
    private static final int ZERO_RESULT = 0;
    private static final String RANKIN_COUNT_SUFFIX = "개\n";
    private static final List<LottoRanking> DEFAULT_LOTTO_RANKING = List.of(
            FIFTH_PRIZE,
            FOURTH_PRIZE,
            THIRD_PRIZE,
            SECOND_PRIZE,
            FIRST_PRIZE
    );

    private final String message;
    private final Amount prizeMoney;

    LottoRanking(String message, Amount prizeMoney) {
        this.message = message;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRanking getLottoRanking(long matchCount, boolean hasBonusNumber) {
        if (matchCount < 3) {
            return DID_NOT_WIN;
        }
        if (matchCount == 3) {
            return FIFTH_PRIZE;
        }
        if (matchCount == 4) {
            return FOURTH_PRIZE;
        }
        if (matchCount == 5 && !hasBonusNumber) {
            return THIRD_PRIZE;
        }
        if (matchCount == 5) {
            return SECOND_PRIZE;
        }
        return FIRST_PRIZE;
    }

    public static Amount getTotalPrizeMoney(List<LottoRanking> lottoRankings) {
        List<Amount> amounts = lottoRankings.stream()
                .map(lottoRanking -> lottoRanking.prizeMoney)
                .toList();
        return amounts.stream()
                .reduce(Amount::add)
                .orElse(DID_NOT_WIN.prizeMoney);
    }

    public static String rankingsToString(List<LottoRanking> lottoRankings) {
        HashMap<LottoRanking, Integer> rankingCount = getRankingCount(lottoRankings);
        return DEFAULT_LOTTO_RANKING.stream()
                .map(ranking -> ranking.message + rankingCount.get(ranking) + RANKIN_COUNT_SUFFIX)
                .reduce((resultRankingMessage, rankingMessage) -> resultRankingMessage + rankingMessage)
                .orElse(StringUtil.EMPTY);
    }

    private static HashMap<LottoRanking, Integer> getRankingCount(List<LottoRanking> lottoRankings) {
        HashMap<LottoRanking, Integer> countLottoRankings = new HashMap<>();
        DEFAULT_LOTTO_RANKING.forEach(ranking -> countLottoRankings.put(ranking, ZERO_RESULT));
        for (LottoRanking ranking : lottoRankings) {
            if (!ranking.equals(DID_NOT_WIN)) {
                Integer count = countLottoRankings.get(ranking);
                countLottoRankings.put(ranking, count + ADD_ONE);
            }
        }
        return countLottoRankings;
    }
}
