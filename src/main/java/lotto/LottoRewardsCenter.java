package lotto;

import config.LottoConfig;

import java.util.List;

public class LottoRewardsCenter {
    private final LottoChecker lottoChecker;

    public LottoRewardsCenter(LottoChecker lottoChecker) {
        this.lottoChecker = lottoChecker;
    }

    public List<LottoPrize> getPrizeResults(List<Lotto> lottos) {
        return lottos.stream().map(lottoChecker::check).toList();
    }
}