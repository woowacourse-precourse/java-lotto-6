package lotto.controller;

import lotto.service.ValidateService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final ValidateService validateService = new ValidateService();

    public void playGame() {
        printPurchaseMoneyMessage();
        String inputPurchaseMoney = inputPurchaseMoneyProcess();
        printBlankLine();


    }

    private void printPurchaseMoneyMessage() {
        outputView.printPurchaseMoneyMessage();
    }

    private String inputPurchaseMoneyProcess() {
        try {
            String inputPurchaseMoney = inputView.inputPurchaseMoney();
            validateService.validateInputPurchaseMoney(inputPurchaseMoney);
            return inputPurchaseMoney;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPurchaseMoneyProcess();
        }
    }

    private void printBlankLine() {
        outputView.printBlankLine();
    }
}
