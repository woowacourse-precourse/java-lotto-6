package lotto.controller;

import java.util.List;

import lotto.model.PurchaseAmount;

import lotto.service.LottoService;

import lotto.view.InputView;
import lotto.view.OutputView;


public class LottoController {
    InputView inputView;
    OutputView outputView;
    LottoService lottoService;

    private static class SingletonLottoController {
        private static final LottoController LOTTO_CONTROLLER = new LottoController();
    }

    public static LottoController getInstance() {
        return SingletonLottoController.LOTTO_CONTROLLER;
    }

    private LottoController() {
        inputView = InputView.getInstance();
        outputView = OutputView.getInstance();
        lottoService = LottoService.getInstance();
    }

    public void purchaseLotto() {
        PurchaseAmount purchaseAmount = inputPurchaseAmount();

        Integer numberOfLotto = purchaseAmount.getNumberOfLotto();

        outputView.printNumberOfPurchaseMessage(numberOfLotto);

        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> lottoNumbers = lottoService.generateLottos();
            outputView.printLottoNumbers(lottoNumbers);
        }
    }

    private PurchaseAmount inputPurchaseAmount() {
        PurchaseAmount purchaseAmount;
        try {
            outputView.printInputPurchaseAmountMessage();

            Long paidMoney = inputView.inputPurchaseAmount();

            purchaseAmount = new PurchaseAmount(paidMoney);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);

            purchaseAmount = inputPurchaseAmount();
        }
        return purchaseAmount;
    }

}
