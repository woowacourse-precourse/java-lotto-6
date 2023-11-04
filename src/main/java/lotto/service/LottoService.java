package lotto.service;

import lotto.domain.LottoCounter;
import lotto.domain.LottoResult;
import lotto.domain.Lottoes;
import lotto.domain.WinningLotto;

public class LottoService {

    private final LottoCounter lottoCounter;
    private final Lottoes lottoes;

    public LottoService(LottoCounter lottoCounter) {
        this.lottoCounter = lottoCounter;
        this.lottoes = new Lottoes(lottoCounter.getTicketCount());
    }

    public void calculateRanking(WinningLotto winningLotto) {
        lottoes.calculateRanking(winningLotto);
    }


    public double getProfit() {
        return lottoes.getResult()
                .getProfit(lottoCounter.getTicketCount());
    }
    public Lottoes getLottoes() {
        return lottoes;
    }

    public LottoResult getResult() {
        return lottoes.getResult();
    }
}
