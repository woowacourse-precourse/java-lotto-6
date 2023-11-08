package lotto.controller;

import lotto.domain.LottoBuyer;
import lotto.domain.LottoSeller;
import lotto.domain.Rank;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;

public class LottoController {

    public void run() {
        LottoBuyer lottoBuyer;

        while (true) {
            try {
                lottoBuyer = new LottoBuyer(InputView.purchaseMoney());
                break;
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        OutputView.printLottoNums(lottoBuyer.getLottos());

        LottoSeller lottoSeller;

        while (true) {
            try {
                lottoSeller = new LottoSeller(InputView.winningNumber(), InputView.bonusNumber());
                break;
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        lottoSeller.contrastWithWinningNumber(lottoBuyer);
        Map<Rank, Integer> result = lottoSeller.getMatchedResult();
        OutputView.printMatchedResult(result);
        OutputView.printRateOfReturn(lottoSeller.calculateRateOfReturn(lottoBuyer, result));
    }
}