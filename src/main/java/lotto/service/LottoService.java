package lotto.service;

import lotto.domain.*;

public class LottoService {

    private final Lottoes lottoes;

    public LottoService(LottoCounter lottoCounter) {
        this.lottoes = new Lottoes(new LottoGenerator(), lottoCounter.getTicketCount());
    }

    public void calculateRanking(WinningLotto winningLotto) {
        lottoes.calculateRanking(winningLotto);
    }

    public double getProfit() {
        return lottoes.getTotalProfit();
    }

    public Lottoes getLottoes() {
        return lottoes;
    }

    public LottoResult getResult() {
        return lottoes.getResult();
    }
}
