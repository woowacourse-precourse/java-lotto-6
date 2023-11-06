package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Deposit;
import lotto.model.LottoTicket;
import lotto.model.WinningNumbers;

import static lotto.controller.LottoDrawingMachine.drawBonusNumber;
import static lotto.controller.LottoDrawingMachine.drawWinningNumbers;
import static lotto.view.InputView.askPurchaseAmount;
import static lotto.view.InputView.askUntilGetValidAnswer;
import static lotto.view.OutputView.*;

public class LottoController {
    public void run() {
        Deposit deposit = makeDeposit();
        LottoTicket lottoTicket = purchaseLottoTicket(deposit);
        WinningNumbers winningNumbers = drawWinningNumbers();
        BonusNumber bonusNumber = drawBonusNumber();
        printDrawingStatistic();
    }

    public Deposit makeDeposit() {
        return (Deposit) askUntilGetValidAnswer(
                () -> {
                    String purchaseAmount = askPurchaseAmount();
                    return new Deposit(purchaseAmount);
                }
        );
    }

    public LottoTicket purchaseLottoTicket(Deposit deposit) {
        Integer purchaseAmount = deposit.calculateBuyableLottoAmount();
        LottoTicket lottoTicket = LottoTicketMachine.issue(purchaseAmount);
        printPurchaseAmount(purchaseAmount);
        printLottoTicket(lottoTicket.toString());
        return lottoTicket;
    }
}
