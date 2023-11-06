package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Deposit;
import lotto.model.LottoTicket;
import lotto.model.WinningNumbers;
import lotto.utils.PrizeType;

import java.util.List;

import static lotto.controller.LottoDrawingMachine.drawBonusNumber;
import static lotto.controller.LottoDrawingMachine.drawWinningNumbers;
import static lotto.controller.LottoStatisticMachine.drawStatistic;
import static lotto.view.InputView.askPurchaseAmount;
import static lotto.view.InputView.askUntilGetValidAnswer;
import static lotto.view.OutputView.printLottoTicket;
import static lotto.view.OutputView.printPurchaseAmount;

public class LottoController {
    public void run() {
        Deposit deposit = makeDeposit();
        LottoTicket lottoTicket = purchaseLottoTicket(deposit);
        WinningNumbers winningNumbers = drawWinningNumbers();
        BonusNumber bonusNumber = drawBonusNumber();
        List<PrizeType> lottoResult = LottoReader.read(winningNumbers, bonusNumber, lottoTicket);
        drawStatistic(lottoResult);
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
