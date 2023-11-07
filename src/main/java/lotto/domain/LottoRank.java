package lotto.domain;

import static lotto.LottoConstance.FIFTY_WINING_COUNT;
import static lotto.LottoConstance.SECOND_AND_THIRD_WINING_COUNT;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoRank {
    FIRST("6개 일치 (2,000,000,000원) - %d개", 6, 2000000000L),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", 5, 30000000L),
    THIRD("5개 일치 (1,500,000원) - %d개", 5, 1500000L),
    FOURTH("4개 일치 (50,000원) - %d개", 4, 50000L),
    FIFTH("3개 일치 (5,000원) - %d개", 3, 5000L),
    NONE("낙첨", 0, 0);

    private final String message;
    private final int matchingCount;
    private final long prize;

    LottoRank(String message, int matchingCount, long prize) {
        this.message = message;
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public static LottoRank get(WinningLottoNumbers winningLottoNumbers, Lotto lotto) {
        int winingCount = winningLottoNumbers.countWining(lotto);
        boolean winingBonus = winningLottoNumbers.isWiningBonus(lotto);

        if (winingCount < FIFTY_WINING_COUNT.get()) {
            return NONE;
        }

        List<LottoRank> lottoRanks = Arrays.stream(values())
                .filter(lottoRank -> lottoRank.getMatchingCount() == winingCount).toList();

        if (winingCount == SECOND_AND_THIRD_WINING_COUNT.get()) {
            return getThirdOrSecond(winingBonus);
        }
        return lottoRanks.get(0);
    }

    private static LottoRank getThirdOrSecond(boolean winingBonus) {
        if (winingBonus) {
            return SECOND;
        }
        return THIRD;
    }

    public String getMessage() {
        return message;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public long getPrize() {
        return prize;
    }

    public static List<LottoRank> getValuesWithoutNone() {
        List<LottoRank> values = Arrays.stream(values()).collect(Collectors.toList());
        values.remove(NONE);
        return values;
    }
}