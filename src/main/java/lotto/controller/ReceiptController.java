package lotto.controller;

import static lotto.configurations.SettingValues.*;

import java.util.List;

import lotto.model.BonusNumber;
import lotto.model.WinningNumbers;

import lotto.service.ReceiptService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class ReceiptController {
    InputView inputView;
    OutputView outputView;
    ReceiptService receiptService;

    private static class SingletonReceiptController {
        private static final ReceiptController RECEIPT_CONTROLLER = new ReceiptController();
    }

    public static ReceiptController getInstance() {
        return SingletonReceiptController.RECEIPT_CONTROLLER;
    }

    private ReceiptController() {
        inputView = InputView.getInstance();
        outputView = OutputView.getInstance();
        receiptService = ReceiptService.getInstance();
    }

    public void showResult() {
        WinningNumbers winningNumbers = inputWinningNumber();
        BonusNumber bonusNumber = inputBonusNumber(winningNumbers);

        receiptService.rankUserLottos(winningNumbers, bonusNumber);

        Integer[] numberOfRanking = receiptService.getNumbersOfRanking();
        Double profitRatio = receiptService.getProfitRatio();
        printReceipt(numberOfRanking, profitRatio);
    }

    private WinningNumbers inputWinningNumber() {
        WinningNumbers winningNumbers;
        try {
            outputView.printInputWinningNumMessage();

            List<Integer> winningNumbersInput = inputView.inputWinningNumbers();

            winningNumbers = new WinningNumbers(winningNumbersInput);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);

            winningNumbers = inputWinningNumber();
        }
        return winningNumbers;
    }

    private BonusNumber inputBonusNumber(WinningNumbers winningNumbers) {
        BonusNumber bonusNumber;
        try {
            outputView.printInputBonusNumMessage();

            Integer bonusNumberInput = inputView.inputBonusNumber();

            bonusNumber = new BonusNumber(winningNumbers, bonusNumberInput);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);

            bonusNumber = inputBonusNumber(winningNumbers);
        }

        return bonusNumber;
    }

    private void printReceipt(Integer[] numbersOfRanking, Double profitRatio) {
        outputView.printReceiptTitle();
        for (int ranking = FIFTH.get(); ranking >= FIRST.get(); ranking--) {
            outputView.printRankingResult(ranking, numbersOfRanking[ranking]);
        }
        outputView.printProfitRatio(profitRatio);
    }
}
