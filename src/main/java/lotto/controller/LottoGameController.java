package lotto.controller;

import java.util.List;
import lotto.model.LottoBundle;
import lotto.model.LottoGenerator;
import lotto.view.InputView;

public class LottoGameController {

    public void play() {
        LottoBundle lottoBundle = LottoGenerator.getLottoBundle();

        List<Integer> winningLotto = InputView.getWinningLotto();
        Integer bonusNumber = InputView.getBonusNumber(winningLotto);


    }
}
