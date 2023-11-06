package lotto.controller;

import java.util.Iterator;
import java.util.Map;
import lotto.controller.handler.BonusNumberHandler;
import lotto.controller.handler.InputHandler;
import lotto.controller.handler.PurchaseAmountHandler;
import lotto.controller.handler.WinningNumberHandler;
import lotto.model.Lotto;
import lotto.model.LottoManager;
import lotto.utils.Message;
import lotto.view.View;

public class controller {
    private View view;
    private LottoManager lottoManager;
    private InputHandler<Map<Integer, Integer>> winningNumberHandler;
    private InputHandler<Integer> purchaseNumberHandler;
    private InputHandler<Integer> bonusNumberHandler;

    public controller() {
        this.view = new View();
        this.lottoManager = new LottoManager();
    }

    public void play() {
        view.displayPurchaseAmountMessage();
        int purchaseAmount = getPurchaseAmount();
        displayIssuedLottoNumbers(purchaseAmount);

        view.displayWinningNumberMessage();
        setWinningNumbers();
        
        displayGameResult();
    }

    private void setWinningNumbers() {
        Map<Integer, Integer> sequencedNumbers = getSequencedNumbers();
        int bonusNumber = getBonusNumber();
        isBonusNumberDuplicated(sequencedNumbers, bonusNumber);
        lottoManager.setWinningNumbers(sequencedNumbers, bonusNumber);
    }

    private void isBonusNumberDuplicated(Map<Integer, Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.containsKey(bonusNumber)) {
            throw new IllegalArgumentException(Message.DUPLICATED_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private void displayGameResult() {
        view.displayWinningStatisticsMessage();
        String statistics = lottoManager.getStatistics();
        view.displayWinningStatistics(statistics);
    }

    private void displayIssuedLottoNumbers(int purchaseAmount) {
        lottoManager.issueLottos(purchaseAmount);
        Iterator<Lotto> lottoIterator = lottoManager.getLottoListIterator();
        view.displayLottos(lottoIterator);
    }

    private int getPurchaseAmount() {
        String purchaseAmount = view.getPurchaseAmount();
        purchaseNumberHandler = new PurchaseAmountHandler(purchaseAmount);
        purchaseNumberHandler.handle();
        return purchaseNumberHandler.getHandledResult();
    }

    private Map<Integer, Integer> getSequencedNumbers() {
        String winningNumbers = view.getWinningNumbers();
        winningNumberHandler = new WinningNumberHandler(winningNumbers);
        winningNumberHandler.handle();
        return winningNumberHandler.getHandledResult();
    }

    private int getBonusNumber() {
        String bonusNumber = view.getBonusNumber();
        bonusNumberHandler = new BonusNumberHandler(bonusNumber);
        bonusNumberHandler.handle();
        return bonusNumberHandler.getHandledResult();
    }
}
