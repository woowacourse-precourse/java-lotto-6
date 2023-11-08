package lotto.controller;


import lotto.model.Lotto;
import lotto.model.LottoManager;
import lotto.model.LottoResult;
import lotto.model.RandomLottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView input = new InputView();
    private final OutputView output = new OutputView();
    private final LottoManager manager = new LottoManager();
    private int purchaseAmount;

    public void run() {
        purchaseLotto();
        determineWinningLotto();
        calculateMatched();
        calculateRateOfRefund();
    }


    private void purchaseLotto() {
        purchaseAmount = input.readPurchaseAmount();
        int numberOfLottos = purchaseAmount / Lotto.PRICE;
        output.printPurchaseAmount(numberOfLottos);

        manager.createLottos(numberOfLottos, new RandomLottoGenerator());
        output.printLottos(manager.getPurchaseLottos());
    }


    private void determineWinningLotto() {
        Lotto lotto = input.readWinningNumbers();
        int bonusNumber = input.readBonusNumber();
        manager.createWinningLotto(lotto, bonusNumber);
    }


    private void calculateMatched() {
        output.printWinningHeader();
        LottoResult lottoResult = manager.calculateLottoResult();
        output.printWinnerStatus(lottoResult);
    }

    private void calculateRateOfRefund() {
        double rateOfReturn = manager.calculateRateOfReturn(purchaseAmount);
        output.printTotalRateOfReturn(rateOfReturn);
    }
}
