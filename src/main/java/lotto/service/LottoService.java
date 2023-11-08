package lotto.service;

import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.PlayerAmount;
import lotto.domain.Profit;
import lotto.domain.RankResult;

public class LottoService {
    private Lottos lottos;
    private LottoResult lottoResult;
    private PlayerAmount playerAmount;

    public LottoService(Lottos lottos, LottoResult lottoResult, PlayerAmount playerAmount) {
        this.lottos = lottos;
        this.lottoResult = lottoResult;
        this.playerAmount = playerAmount;
    }

    public RankResult getLottoRankResult() {
        RankResult rankResult = new RankResult();
        rankResult.calcuateRankResult(lottos, lottoResult);

        return rankResult;
    }

    public Profit getLottoProfitRate(RankResult rankResult) {
        return new Profit(playerAmount, rankResult);
    }
}
