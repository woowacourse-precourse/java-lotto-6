package lotto.controller;

import lotto.model.Deposit;
import lotto.model.LottoTicket;
import lotto.service.LottoTicketIssuer;

import static lotto.view.InputView.askPurchaseAmount;
import static lotto.view.InputView.askUntilGetValidAnswer;
import static lotto.view.OutputView.printLottoTicket;
import static lotto.view.OutputView.printPurchaseAmount;

public class LottoSeller {
    public static Deposit makeDeposit() {
        return (Deposit) askUntilGetValidAnswer(
                () -> {
                    String purchaseAmount = askPurchaseAmount();
                    return new Deposit(purchaseAmount);
                }
        );
    }

    public static LottoTicket purchaseLottoTicket(Deposit deposit) {
        Integer purchaseAmount = deposit.calculateBuyableLottoAmount();
        printPurchaseAmount(purchaseAmount);

        LottoTicket lottoTicket = LottoTicketIssuer.issue(purchaseAmount);
        printLottoTicket(lottoTicket.toString());

        return lottoTicket;
    }
}
