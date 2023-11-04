package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    private final WinningNumber winningNumber = new WinningNumber();
    private final LottoIssueController lottoIssueController = new LottoIssueController();
    private final WinningNumberController winningNumberController = new WinningNumberController();
    private final NumberMatchController numberMatchController = new NumberMatchController();
    private final LottoResultController lottoResultController = new LottoResultController();
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

    public Lottos purchaseLottos(int inputMoney) {
        Lottos lottos = lottoIssueController.createLottos(inputMoney);
        getPurchaseDetails(inputMoney, lottos);
        return lottos;
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

    private void matchLottos(Lottos lottos) {
        numberMatchController.matchAllLottos(lottos, winningNumber);
    }

    private void getWinningStatistics() {
        //당첨 통계 출력
    }

    private void calculateProfitRate(Lottos lottos, int inputMoney) {
        lottoResultController.findStatistics(lottos);

        int totalProfit = lottoResultController.getTotalProfit();
        String profitRate = lottoResultController.getProfitRate(totalProfit, inputMoney);
        outputView.printProfitRate(profitRate);
    }

    public void play() {
        int inputMoney = getMoneyInput();
        Lottos lottos = purchaseLottos(inputMoney);

        setWinningNumber();
        matchLottos(lottos);
        getWinningStatistics();
        calculateProfitRate(lottos, inputMoney);
    }
}
