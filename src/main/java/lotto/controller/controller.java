package lotto.controller;

import java.util.Iterator;
import java.util.Map;
import lotto.controller.handler.BonusNumberHandler;
import lotto.controller.handler.InputHandler;
import lotto.controller.handler.PurchaseAmountHandler;
import lotto.controller.handler.WinningNumberHandler;
import lotto.model.Lotto;
import lotto.model.LottoManager;
import lotto.model.WinningStatistics;
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
        int lottoCount = getLottoCount();

        lottoManager.issueLottos(lottoCount);
        Iterator<Lotto> lottoIterator = lottoManager.getLottoListIterator();
        view.displayRandomLottos(lottoIterator);

        view.displayWinningNumberMessage();
        Map<Integer, Integer> winningNumbers = getWinningNumbers();
        lottoManager.setWinningNumbers(winningNumbers);

        int bonusNumber = getBonusNumber();
        lottoManager.isDuplicatedBonusNumber(bonusNumber);

        view.displayWinningStatisticsMessage();
        WinningStatistics winningStatistics = getWinningStatistics();
        view.displayWinningStatistics(winningStatistics);

    }


    private int getLottoCount() {
        String purchaseAmount = view.getPurchaseAmount();
        purchaseNumberHandler = new PurchaseAmountHandler(purchaseAmount);
        purchaseNumberHandler.handle();
        return purchaseNumberHandler.getHandledResult();
    }

    private Map<Integer, Integer> getWinningNumbers() {
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

    private WinningStatistics getWinningStatistics() {
        return lottoManager.getWinningStatistics();
    }
}
