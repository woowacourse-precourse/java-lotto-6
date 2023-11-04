package lotto.service;

import lotto.domain.LottoResultCount;
import lotto.view.OutputView;

public class ResultService {
    private LottoResultCount lottoResultCount;
    private OutputView outputView = new OutputView();
    private int amount;

    public ResultService(LottoResultCount lottoResultCount, int amount) {
        this.lottoResultCount = lottoResultCount;
        this.amount = amount;
    }

    public void lottoResult() {
        outputView.outputWinningResult(lottoResultCount);
    }

}
