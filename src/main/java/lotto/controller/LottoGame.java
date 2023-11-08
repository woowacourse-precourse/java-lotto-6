package lotto.controller;

import java.util.List;
import lotto.model.LottoManager;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        int amount = getPurchase();
        LottoManager lottoManager = createLottoManager(amount);
        answerForPurchase(lottoManager);

        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);

        lottoManager.checkLottosResult(winningNumbers, bonusNumber);
        double rateOfReturn = lottoManager.getRateOfReturn();

        printResult(lottoManager, rateOfReturn);
    }

    private void printResult(LottoManager lottoManager, double rateOfReturn) {
        outputView.printLottoResult(lottoManager.printLottosResult(), rateOfReturn);
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        outputView.askForBonusNumber();
        return inputView.getBonusNumber(winningNumbers);
    }

    private List<Integer> getWinningNumbers() {
        outputView.askForWinningNumbers();
        return inputView.getWinningNumbers();
    }

    private void answerForPurchase(LottoManager lottoManager) {
        outputView.answerForPurchase(lottoManager.getLottoTicketCount(), lottoManager.getLottoNumbers());
    }

    private int getPurchase() {
        outputView.askForPurchaseAmount();
        return inputView.getPurchaseAmount();
    }

    private static LottoManager createLottoManager(int amount) {
        LottoManager lottoManager = new LottoManager(amount);
        lottoManager.issueLottos();
        return lottoManager;
    }
}
