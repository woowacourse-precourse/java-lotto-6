package lotto.gameStarter;

import lotto.outputPrint.GameGuidePrint;
import lotto.outputPrint.PurchasedLottoNumbersPrint;
import lotto.outputPrint.WinningStatistics;
import lotto.readUserInput.BonusNumbers;
import lotto.readUserInput.PurchaseAmount;
import lotto.readUserInput.WinningNumbers;
import lotto.service.PurchasedLottoTickets;
import lotto.service.RateOfReturn;

public class LottoGame {
    GameGuidePrint gameGuidePrint = new GameGuidePrint();
    private PurchaseAmount purchaseAmount = new PurchaseAmount();
    private WinningNumbers winningNumbers = new WinningNumbers();
    private BonusNumbers bonusNumbers = new BonusNumbers();
    private PurchasedLottoTickets purchasedLottoTickets = new PurchasedLottoTickets();
    private PurchasedLottoNumbersPrint purchasedLottoNumbersPrint = new PurchasedLottoNumbersPrint(
            purchasedLottoTickets);
    private WinningStatistics winningStatistics = new WinningStatistics();
    private RateOfReturn rateOfReturn = new RateOfReturn(purchasedLottoTickets);

    public void run() {
        purchaseLotto();
        whatWinningNumbers();
        whatBonusNumber();
        resultPrint();
    }

    public void purchaseLotto() {
        gameGuidePrint.scanPurchasePrint();
        purchaseAmount.read();
        purchasedLottoTickets.register(purchaseAmount);
        purchasedLottoPrint();
    }

    public void whatWinningNumbers() {
        gameGuidePrint.scanWinningNumberPrint();
        winningNumbers.read();
    }

    public void whatBonusNumber() {
        gameGuidePrint.scanBonusNumberPrint();
        bonusNumbers.read();
    }

    public void purchasedLottoPrint() {
        purchasedLottoNumbersPrint.purchaseCompletePrint(purchaseAmount);
        purchasedLottoNumbersPrint.printTickets();
    }

    public void resultPrint() {
        gameGuidePrint.resultGame();
        winningStatistics.printStatistics(purchasedLottoTickets);
        resultReturn();
    }

    public void resultReturn() {
        rateOfReturn.initTicketResult();
        rateOfReturn.printRateOfReturn();
    }
}