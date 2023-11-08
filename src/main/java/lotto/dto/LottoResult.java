package lotto.dto;

import java.util.Map;
import lotto.LottoRank;

public record LottoResult(
        LottoResultEntry first,
        LottoResultEntry second,
        LottoResultEntry third,
        LottoResultEntry fourth,
        LottoResultEntry fifth,
        double profitRate
) {

    public static LottoResult from(Map<LottoRank, Long> rankMap, double profitRate) {
        return new LottoResult(
                new LottoResultEntry(
                        MoneyDto.from(LottoRank.FIRST.getPrize()),
                        rankMap.getOrDefault(LottoRank.FIRST, 0L).intValue()),
                new LottoResultEntry(
                        MoneyDto.from(LottoRank.SECOND.getPrize()),
                        rankMap.getOrDefault(LottoRank.SECOND, 0L).intValue()),
                new LottoResultEntry(
                        MoneyDto.from(LottoRank.THIRD.getPrize()),
                        rankMap.getOrDefault(LottoRank.THIRD, 0L).intValue()),
                new LottoResultEntry(
                        MoneyDto.from(LottoRank.FOURTH.getPrize()),
                        rankMap.getOrDefault(LottoRank.FOURTH, 0L).intValue()),
                new LottoResultEntry(
                        MoneyDto.from(LottoRank.FIFTH.getPrize()),
                        rankMap.getOrDefault(LottoRank.FIFTH, 0L).intValue()),
                profitRate * 100
        );
    }
}
