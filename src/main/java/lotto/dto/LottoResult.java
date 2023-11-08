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
                        LottoRank.FIRST.getPrize().getValue(),
                        rankMap.getOrDefault(LottoRank.FIRST, 0L).intValue()),
                new LottoResultEntry(
                        LottoRank.SECOND.getPrize().getValue(),
                        rankMap.getOrDefault(LottoRank.SECOND, 0L).intValue()),
                new LottoResultEntry(
                        LottoRank.THIRD.getPrize().getValue(),
                        rankMap.getOrDefault(LottoRank.THIRD, 0L).intValue()),
                new LottoResultEntry(
                        LottoRank.FOURTH.getPrize().getValue(),
                        rankMap.getOrDefault(LottoRank.FOURTH, 0L).intValue()),
                new LottoResultEntry(
                        LottoRank.FIFTH.getPrize().getValue(),
                        rankMap.getOrDefault(LottoRank.FIFTH, 0L).intValue()),
                profitRate
        );
    }
}
