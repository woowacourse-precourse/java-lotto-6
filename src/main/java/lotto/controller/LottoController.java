package lotto.controller;

import lotto.domain.LottoBuyer;
import lotto.domain.LottoSeller;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        LottoBuyer lottoBuyer = new LottoBuyer(InputView.purchaseMoney());
        OutputView.printLottoNums(lottoBuyer.getLottos());
        LottoSeller lottoSeller = new LottoSeller(InputView.winningNumber(), InputView.bonusNumber());
    }
}