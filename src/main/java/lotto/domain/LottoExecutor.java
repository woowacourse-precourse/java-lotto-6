package lotto.domain;

import java.util.Map;
import lotto.service.LottoService;
import lotto.service.dto.Result;

public class LottoExecutor {

    private static final LottoExecutor instance = new LottoExecutor();


    private LottoExecutor() {
    }

    public static LottoExecutor getInstance() {
        return instance;
    }

    public Result execute(
            final LottoBundle lottoBundle,
            final Lotto winningLotto,
            final BonusNumber bonusNumber
    ) {

        Map<Rank, Integer> totalRankWithCount = lottoBundle.calculateTotalRank(
                winningLotto,
                bonusNumber
        );
        int totalPrize = calculateTotalPrize(totalRankWithCount);
        float earningRate = lottoBundle.calculateEarningRate(totalPrize);

        return Result.of(totalRankWithCount, earningRate);
    }

    private static int calculateTotalPrize(Map<Rank, Integer> totalRankWithCount) {
        return totalRankWithCount.keySet()
                .stream()
                .mapToInt(rank -> rank.multiple(totalRankWithCount.get(rank)))
                .sum();
    }

}
