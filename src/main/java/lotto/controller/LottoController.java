package lotto.controller;

import lotto.model.Deposit;
import lotto.model.LottoMachine;
import lotto.model.LottoTicket;
import lotto.view.InputView;

import static lotto.view.OutputView.printLottoTicket;
import static lotto.view.OutputView.printPurchaseAmount;

public class LottoController {
    public void run() {
        Deposit deposit = makeDeposit();
        LottoTicket lottoTicket = purchaseLottoTicket(deposit);
    }

    public Deposit makeDeposit() {
        while (true) {
            try {
                String purchaseAmount = InputView.askPurchaseAmount();
                return new Deposit(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public LottoTicket purchaseLottoTicket(Deposit deposit) {
        Integer purchaseAmount = deposit.calculateBuyableLottoAmount();
        LottoTicket lottoTicket = LottoMachine.issue(purchaseAmount);
        printPurchaseAmount(purchaseAmount);
        printLottoTicket(lottoTicket);
        return lottoTicket;
    }
}
