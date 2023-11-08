package controller;

import domain.Lotto;
import java.util.List;
import view.LottoDetailOutput;
import view.LottoOutput;

public class OutputController {

    private final int LOTTO_PRICE = 1000;

    private static final LottoOutput lottoOutput = new LottoOutput();
    private static final LottoDetailOutput lottoDetailOutput = new LottoDetailOutput();

    public void outputRandomLotto(int money, List<Lotto> allLotto) {
        lottoOutput.lottoOutput(money / LOTTO_PRICE, allLotto);
        System.out.println();
    }

    public void outputLotto(int[] answerCount, int money) {
        lottoDetailOutput.detailOutput(answerCount);
        lottoDetailOutput.totalProfitOutput(money);
    }
}
