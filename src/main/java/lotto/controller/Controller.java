package lotto.controller;

import java.util.Iterator;
import java.util.Set;
import lotto.controller.handler.BonusNumberHandler;
import lotto.controller.handler.InputHandler;
import lotto.controller.handler.PurchaseAmountHandler;
import lotto.controller.handler.WinningNumberHandler;
import lotto.model.Lotto;
import lotto.model.LottoManager;
import lotto.utils.GameConstants;
import lotto.utils.Message;
import lotto.view.View;

public class Controller {
    private View view;
    private LottoManager lottoManager;
    private InputHandler<Set<Integer>> winningNumberHandler;
    private InputHandler<Integer> purchaseNumberHandler;
    private InputHandler<Integer> bonusNumberHandler;

    public Controller() {
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
        Set<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();
        isBonusNumberDuplicated(winningNumbers, bonusNumber);
        lottoManager.setPrizeNumbers(winningNumbers, bonusNumber);
    }

    private void isBonusNumberDuplicated(Set<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(Message.DUPLICATED_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private void displayGameResult() {
        view.displayWinningStatisticsMessage();
        String statistics = lottoManager.getStatistics();
        view.displayWinningStatistics(statistics);
    }

    private void displayIssuedLottoNumbers(int purchaseAmount) {
        int lottoCount = purchaseAmount / GameConstants.UNIT_PURCHASE_PRICE;
        view.displayIssuedLottoCount(lottoCount);
        lottoManager.issueLottos(purchaseAmount);
        Iterator<Lotto> lottoIterator = lottoManager.getLottoListIterator();
        view.displayLottos(lottoIterator);
    }

    private int getPurchaseAmount() {
        String purchaseAmount = view.getPurchaseAmount();
        purchaseNumberHandler = new PurchaseAmountHandler(purchaseAmount);
        try {
            purchaseNumberHandler.handle();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber();
        }

        return purchaseNumberHandler.getHandledResult();
    }

    private Set<Integer> getWinningNumbers() {
        String winningNumbers = view.getWinningNumbers();
        winningNumberHandler = new WinningNumberHandler(winningNumbers);
        try {
            winningNumberHandler.handle();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumbers();
        }

        return winningNumberHandler.getHandledResult();
    }

    private int getBonusNumber() {
        String bonusNumber = view.getBonusNumber();
        bonusNumberHandler = new BonusNumberHandler(bonusNumber);
        try {
            bonusNumberHandler.handle();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber();
        }
        return bonusNumberHandler.getHandledResult();
    }
}
