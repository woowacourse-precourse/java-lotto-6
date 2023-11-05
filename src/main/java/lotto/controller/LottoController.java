package lotto.controller;

import lotto.service.LottoService;
import lotto.service.ValidateService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final ValidateService validateService = new ValidateService();
    private final LottoService lottoService = new LottoService();

    public void playGame() {
        printPurchaseMoneyMessage();
        String inputPurchaseMoney = inputPurchaseMoneyProcess();
        printLottoCount(inputPurchaseMoney);
        printPurchaseLottoNumbers();
        printWinnerNumberMessage();
        String inputWinnerNumber = inputWinnerNumberProcess();
    }

    private void printPurchaseLottoNumbers() {
        List<List<Integer>> purchaseLottoNumbers = lottoService.purchaseLottoNumberProcess();
        outputView.printPurchaseLottoNumbers(purchaseLottoNumbers);
        printBlankLine();
    }

    private void printPurchaseMoneyMessage() {
        outputView.printPurchaseMoneyMessage();
    }

    private String inputPurchaseMoneyProcess() {
        try {
            String inputPurchaseMoney = inputView.inputPurchaseMoney();
            validateService.validateInputPurchaseMoney(inputPurchaseMoney);
            printBlankLine();
            return inputPurchaseMoney;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPurchaseMoneyProcess();
        }
    }

    private void printBlankLine() {
        outputView.printBlankLine();
    }

    private void printLottoCount(String inputPurchaseMoney) {
        int lottoCount = getLottoCount(inputPurchaseMoney);
        outputView.printLottoCountMessage(lottoCount);
    }

    private int getLottoCount(String inputPurchaseMoney) {
        return lottoService.getLottoCount(inputPurchaseMoney);
    }

    private void printWinnerNumberMessage() {
        outputView.printWinnerNumberMessage();
    }

    private String inputWinnerNumberProcess() {
        try {
            String inputWinnerNumber = inputView.inputWinnerNumber();
            validateService.validateInputWinnerNumber(inputWinnerNumber);
            printBlankLine();
            return inputWinnerNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinnerNumberProcess();
        }
    }
}
