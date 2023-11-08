package lotto.controller;

import lotto.model.Ranking;
import lotto.service.LottoService;
import lotto.service.ValidateService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

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
        setWinnerNumber(inputWinnerNumber);
        printBonusNumberMessage();
        String inputBonusNumber = inputBonusNumberProcess();
        setBonusNumber(inputBonusNumber);
        Map<Ranking, Integer> result = winningStatisticsProcess();
        printRevenueRate(result);
    }

    private void printRevenueRate(Map<Ranking, Integer> result) {
        double revenueRate = lottoService.getRevenueRate(result);
        outputView.printRevenueRate(revenueRate);
    }

    private Map<Ranking, Integer> winningStatisticsProcess() {
        outputView.printWinningStaticsMessage();
        Map<Ranking, Integer> result = lottoService.calculatePrizeMoney();
        for (int i = Ranking.values().length - 1; i >= 0; i--) {
            Ranking.values()[i].printMessage(result.get(Ranking.values()[i]));
        }
        return result;
    }

    private void setBonusNumber(String inputBonusNumber) {
        lottoService.setBonusNumber(inputBonusNumber);
    }

    private String inputBonusNumberProcess() {
        try {
            String inputBonusNumber = inputView.inputBonusNumber();
            validateService.validateInputBonusNumber(inputBonusNumber);
            printBlankLine();
            return inputBonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumberProcess();
        }

    }

    private void printBonusNumberMessage() {
        outputView.printBonusNumberMessage();
    }

    private void setWinnerNumber(String inputWinnerNumber) {
        lottoService.setWinnerLottoNumbers(inputWinnerNumber);
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
