package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;

import java.util.List;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.printLottoTicket;
import static lotto.view.OutputView.printPurchaseAmount;

public class LottoController {
    public void run() {
        Deposit deposit = makeDeposit();
        LottoTicket lottoTicket = purchaseLottoTicket(deposit);
        LottoReader lottoReader = drawLotto();
        List<Integer> read = lottoReader.read(lottoTicket);
        for (Integer i : read) {
            System.out.println(i);
        }
    }

    public Deposit makeDeposit() {
        return (Deposit) askUntilGetValidAnswer(
                () -> {
                    String purchaseAmount = InputView.askPurchaseAmount();
                    return new Deposit(purchaseAmount);
                }
        );
    }

    public LottoTicket purchaseLottoTicket(Deposit deposit) {
        Integer purchaseAmount = deposit.calculateBuyableLottoAmount();
        LottoTicket lottoTicket = LottoTicketMachine.issue(purchaseAmount);
        printPurchaseAmount(purchaseAmount);
        printLottoTicket(lottoTicket);
        return lottoTicket;
    }

    public LottoReader drawLotto() {
        WinningNumbers winningNumbers = drawWinningNumbers();
        BonusNumber bonusNumber = drawBonusNumber();
        return new LottoReader(winningNumbers, bonusNumber);
    }

    private WinningNumbers drawWinningNumbers() {
        return (WinningNumbers) askUntilGetValidAnswer(
                () -> {
                    String winningNumber = askWinningNumber();
                    return new WinningNumbers(winningNumber);
                }
        );
    }

    private BonusNumber drawBonusNumber() {
        return (BonusNumber) askUntilGetValidAnswer(
                () -> {
                    String bonusNumber = askBonusNumberMessage();
                    return new BonusNumber(bonusNumber);
                }
        );
    }
}
