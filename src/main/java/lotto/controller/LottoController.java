package lotto.controller;

import lotto.domain.LottoBuyer;
import lotto.domain.LottoSeller;
import lotto.domain.Rank;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.EnumMap;
import java.util.Map;

public class LottoController {

    public void run() {
        LottoBuyer lottoBuyer = new LottoBuyer(InputView.purchaseMoney());
        OutputView.printLottoNums(lottoBuyer.getLottos());
        LottoSeller lottoSeller = new LottoSeller(InputView.winningNumber(), InputView.bonusNumber());
        lottoSeller.contrastWithWinningNumber(lottoBuyer.getLottos());
        Map<Rank, Integer> result = lottoSeller.getMatchedResult();
        System.out.println("result = " + result);
    }
}