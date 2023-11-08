package lotto.controller;

import static lotto.configurations.SettingValues.*;

import java.util.List;

import lotto.model.BonusNumber;
import lotto.model.WinningNumbers;

import lotto.service.RankingService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class RankingController {
    InputView inputView;
    OutputView outputView;
    RankingService rankingService;

    private static class SingletonReceiptController {
        private static final RankingController RECEIPT_CONTROLLER = new RankingController();
    }

    public static RankingController getInstance() {
        return SingletonReceiptController.RECEIPT_CONTROLLER;
    }

    private RankingController() {
        inputView = InputView.getInstance();
        outputView = OutputView.getInstance();
        rankingService = RankingService.getInstance();
    }

    public void rankLottos() {
        WinningNumbers winningNumbers = inputWinningNumber();
        BonusNumber bonusNumber = inputBonusNumber(winningNumbers);

        rankingService.rankLottos(winningNumbers, bonusNumber);

        Integer[] numberOfRanking = rankingService.getNumbersOfRanking();
        Double profitRatio = rankingService.getProfitRatio();
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
