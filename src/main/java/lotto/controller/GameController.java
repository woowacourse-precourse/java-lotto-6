package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private Lottos lottos;
    private final WinningNumber winningNumber = new WinningNumber();
    private final LottoIssueController lottoIssueController = new LottoIssueController();
    private final WinningNumberController winningNumberController = new WinningNumberController();
    private final NumberMatchController numberMatchController = new NumberMatchController();
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    private int getMoneyInput() {
        outputView.printInputMoneyMessage();
        return inputView.getMoney();
    }

    private void getPurchaseDetails(int inputMoney, Lottos lottos) {
        outputView.printPurchaseDetailsMessage(lottoIssueController.getLottoCount(inputMoney));
        outputView.printPurchasedLottos(lottos.getPurchaseDetails());
    }

    public void purchaseLottos() {
        int inputMoney = getMoneyInput();
        lottos = lottoIssueController.createLottos(inputMoney);
        getPurchaseDetails(inputMoney, lottos);
    }

    private String getWinningNumbersInput() {
        outputView.printInputWinningNumbersMessage();
        return inputView.getWinningNumbersInput();
    }

    private String getBonusNumberInput() {
        outputView.printInputBonusNumberMessage();
        return inputView.getBonusNumberInput();
    }

    public void setWinningNumber() {
        String inputNumbers = getWinningNumbersInput();
        winningNumberController.setInputToWinningNumbers(winningNumber, inputNumbers);

        String inputNumber = getBonusNumberInput();
        winningNumberController.setInputToBonusNumber(winningNumber, inputNumber);
    }

    private void matchLottos() {
        numberMatchController.matchAllLottos(lottos, winningNumber);
    }

    public void play() {
        purchaseLottos();
        setWinningNumber();
        matchLottos();
    }
}
