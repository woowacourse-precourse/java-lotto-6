package lotto.model;

import java.util.List;
import lotto.constant.LottoRanking;
import lotto.dto.LottosInfo;
import lotto.dto.RateOfReturn;
import lotto.dto.WinningStatistics;

public class LottoOwner {
    private final PurchasePrice purchasePrice;
    private final List<Lotto> lottos;
    private final LottoResult lottoResults;

    private LottoOwner(PurchasePrice purchasePrice, List<Lotto> lottos, LottoResult lottoResults) {
        this.purchasePrice = purchasePrice;
        this.lottos = lottos;
        this.lottoResults = lottoResults;
    }

    public static LottoOwner of(PurchasePrice purchasePrice, List<Lotto> lottos, LottoResult lottoResults) {
        return new LottoOwner(purchasePrice, lottos, lottoResults);
    }

    public LottosInfo getLottosInfo() {
        List<String> lottosText = lottos.stream()
                .map(Lotto::toString)
                .toList();
        return new LottosInfo(lottosText);
    }

    public void matchLottosWithWinningLotto(WinningLotto winningLotto) {
        lottos.forEach(lotto -> {
            LottoRanking lottoRanking = winningLotto.calculateLottoRanking(lotto);
            lottoResults.addLottoResult(lottoRanking);
        });
    }

    public WinningStatistics getWinningStatistics() {
        return lottoResults.getWinnerStatistics();
    }

    public RateOfReturn convertResultToRateOfReturn() {
        return new RateOfReturn(purchasePrice.calculateRateOfReturn(lottoResults.calculatePrizeSum()));
    }
}
