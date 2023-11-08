package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;


public class LottoRound {
    private LottoBatch lottoBatch;
    private PrizeNumbers prizeNumbers;
    private LottoBatchResult lottoBatchResult;

    public void start() {
        OutputView.printPurchaseAmountInputMessage();
        Integer lottoCount = generateLottoCount();
        OutputView.printLottoCountMessage(lottoCount);
        

    }

    public Integer generateLottoCount() {
        try {
            LottoCount lottoCount = new LottoCount(InputView.inputPurchaseAmount());
            return lottoCount.getValue();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return generateLottoCount();
        }
    }


}
