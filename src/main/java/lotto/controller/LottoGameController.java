package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoBundle;
import lotto.model.LottoGenerator;
import lotto.model.ResultJudge;
import lotto.view.InputView;

public class LottoGameController {

    public void play() {
        LottoBundle lottoBundle = LottoGenerator.getLottoBundle();

        Lotto winningLotto = InputView.getWinningLotto();
        Integer bonusNumber = InputView.getBonusNumber(winningLotto);

        ResultJudge.judge(lottoBundle, winningLotto, bonusNumber);
    }
}
