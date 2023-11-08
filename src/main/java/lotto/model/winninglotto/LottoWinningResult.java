package lotto.model.winninglotto;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.LottoRanking;

public class LottoWinningResult {

    private final EnumMap<LottoRanking, Integer> lottoResult;

    LottoWinningResult(List<LottoRanking> lottoRankings) {
        this.lottoResult = countRankings(lottoRankings);
    }

    public double getLottoProfitRate(int purchaseAmount) {
        return LottoProfitRateCalculator.calculateLottoProfitRate(lottoResult, purchaseAmount);
    }

    private EnumMap<LottoRanking, Integer> countRankings(List<LottoRanking> lottoRankings) {
        return lottoRankings
            .stream()
            .collect(Collectors.toMap(
                lottoRanking -> lottoRanking,
                lottoRanking -> 1
                , Integer::sum,
                () -> new EnumMap<>(LottoRanking.class)
            ));
    }
}
