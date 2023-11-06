package lotto;

import lotto.outputPrint.GameGuidePrint;
import lotto.outputPrint.PurchasedLottoNumbersPrint;
import lotto.outputPrint.WinningStatistics;
import lotto.readUserInput.BonusNumbers;
import lotto.readUserInput.PurchaseAmount;
import lotto.readUserInput.WinningNumbers;
import lotto.service.PurchasedLottoTickets;
import lotto.service.RandomNumbers;
import lotto.service.RateOfReturn;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameGuidePrint gameGuidePrint = new GameGuidePrint();
        gameGuidePrint.scanPurchasePrint();

        PurchaseAmount purchaseAmount = new PurchaseAmount();
        purchaseAmount.read();

        gameGuidePrint.purchaseCompletePrint();

        PurchasedLottoTickets purchasedLottoTickets = new PurchasedLottoTickets();
        purchasedLottoTickets.register();

        PurchasedLottoNumbersPrint purchasedLottoNumbersPrint = new PurchasedLottoNumbersPrint(purchasedLottoTickets);
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
