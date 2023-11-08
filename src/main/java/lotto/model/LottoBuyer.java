package lotto.model;

import lotto.model.dto.AnalyzerWinningStatistics;
import lotto.model.dto.BuyerLottoHistory;
import lotto.model.lottonumbersgenerator.LottoNumbersGenerator;

public class LottoBuyer {
    private Lottos lottos;

    public void buyLotto(int purchaseAmount, LottoNumbersGenerator lottoNumbersGenerator) {
        this.lottos = LottoSeller.sellLotto(purchaseAmount, lottoNumbersGenerator);
    }

    public BuyerLottoHistory generateBuyerLottoHistory() {
        return BuyerLottoHistory.of(lottos);
    }

    public AnalyzerWinningStatistics calculateWinningStatistics(WinningNumbers winningNumbers) {
        LottoWinningAnalyzer lottoWinningAnalyzer = new LottoWinningAnalyzer(lottos, winningNumbers);
        return lottoWinningAnalyzer.generateWinningStatistics();
    }
}
