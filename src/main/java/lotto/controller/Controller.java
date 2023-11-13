package lotto.controller;

import java.util.Set;
import lotto.controller.handler.BonusNumberHandler;
import lotto.controller.handler.InputHandler;
import lotto.controller.handler.PurchaseAmountHandler;
import lotto.controller.handler.WinningNumberHandler;
import lotto.model.LottoManager;
import lotto.utils.GameConstants;
import lotto.utils.Message;
import lotto.view.View;

public class Controller {
    private View view;
    private LottoManager lottoManager;

    public Controller() {
        this.lottoManager = new LottoManager();
        this.view = new View(lottoManager);
    }

    public void play() {
        view.displayPurchaseAmountMessage();
        int purchaseAmount = getPurchaseAmount();

        int lottoCount = getLottoCount(purchaseAmount);
        view.displayLottoCount(lottoCount);
        lottoManager.issueLottos(purchaseAmount);

        view.displayWinningNumberMessage();
        Set<Integer> winningNumbers = getWinningNumbers();

        view.displayBonusNumberMessage();
        int bonusNumber = getBonusNumber(winningNumbers);
        lottoManager.setPrizeNumbers(winningNumbers, bonusNumber);

        displayGameResult();
    }

    private int getLottoCount(int purchaseAmount) {
        return purchaseAmount / GameConstants.UNIT_PURCHASE_PRICE;
    }

    private void displayGameResult() {
        view.displayWinningStatisticsMessage();
        lottoManager.calculateStatistics();
    }

    private int getPurchaseAmount() {
        while (true) {
            String purchaseAmount = view.getPurchaseAmount();
            InputHandler<Integer> purchaseNumberHandler = new PurchaseAmountHandler(purchaseAmount);
            try {
                purchaseNumberHandler.handle();
                return purchaseNumberHandler.getHandledResult();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private Set<Integer> getWinningNumbers() {
        while (true) {
            String winningNumbers = view.getWinningNumbers();
            InputHandler<Set<Integer>> winningNumberHandler = new WinningNumberHandler(winningNumbers);
            try {
                winningNumberHandler.handle();
                return winningNumberHandler.getHandledResult();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getBonusNumber(Set<Integer> winningNumbers) {
        while (true) {
            String bonusNumber = view.getBonusNumber();
            InputHandler<Integer> bonusNumberHandler = new BonusNumberHandler(bonusNumber);
            try {
                bonusNumberHandler.handle();
                int numericBonusNumber = bonusNumberHandler.getHandledResult();
                isBonusNumberDuplicated(winningNumbers, numericBonusNumber);
                return numericBonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void isBonusNumberDuplicated(Set<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(Message.DUPLICATED_NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
