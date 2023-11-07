package lotto.Controller;

import lotto.outputPrint.GameGuidePrint;
import lotto.outputPrint.PurchasedLottoNumbersPrint;
import lotto.outputPrint.WinningStatistics;
import lotto.readUserInput.BonusNumbers;
import lotto.readUserInput.PurchaseAmount;
import lotto.readUserInput.WinningNumbers;
import lotto.service.PurchasedLottoTickets;
import lotto.service.RateOfReturn;

public class LottoGameController {

    public void run() {
        GameGuidePrint gameGuidePrint = new GameGuidePrint();
        gameGuidePrint.scanPurchasePrint();

        PurchaseAmount purchaseAmount = new PurchaseAmount();
        purchaseAmount.read();

        PurchasedLottoTickets purchasedLottoTickets = new PurchasedLottoTickets(purchaseAmount);

        PurchasedLottoNumbersPrint purchasedLottoNumbersPrint = new PurchasedLottoNumbersPrint(purchasedLottoTickets,
                purchaseAmount);
        purchasedLottoNumbersPrint.purchaseCompletePrint();

        purchasedLottoNumbersPrint.printTickets();

        gameGuidePrint.scanWinningNumberPrint();

        WinningNumbers winningNumbers = new WinningNumbers();
        winningNumbers.read();

        gameGuidePrint.scanBonusNumberPrint();

        BonusNumbers bonusNumbers = new BonusNumbers();
        bonusNumbers.read();

        gameGuidePrint.resultGame();

        WinningStatistics winningStatistics = new WinningStatistics(purchasedLottoTickets);
        winningStatistics.printStatistics();

        RateOfReturn rateOfReturn = new RateOfReturn(purchasedLottoTickets);
        rateOfReturn.printRateOfReturn();
    }
}
