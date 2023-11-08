package lotto.service;

import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.RankResult;

public class LottoService {
    private Lottos lottos;
    private LottoResult lottoResult;

    public LottoService(Lottos lottos, LottoResult lottoResult) {
        this.lottos = lottos;
        this.lottoResult = lottoResult;
    }

    public void getLottoRankResult() {
        RankResult rankResult = new RankResult();
        rankResult.calcuateRankResult(lottos, lottoResult);


    }
}
