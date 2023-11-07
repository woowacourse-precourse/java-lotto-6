package controller;

import java.util.List;

import lotto.LottoMoney;
import lotto.LuckeyLotto;
import view.OutputView;

public class LottoController {
    LuckeyLotto luckeyLotto;
    LottoMoney lottoMoney;

    OutputView outputView = new OutputView();

    public LottoController(LottoMoney lottoMoney, LuckeyLotto luckeyLotto) {
        this.lottoMoney = lottoMoney;
        this.luckeyLotto = luckeyLotto;
    }

    public void playGame(List<List<Integer>> lottonumbers) {
        outputView.printLottoResultMessage();
    }
}
