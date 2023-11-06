package lotto.controller;

import lotto.model.Deposit;
import lotto.model.LottoMachine;
import lotto.model.LottoReader;
import lotto.model.LottoReader.BonusNumber;
import lotto.model.LottoReader.WinningNumbers;
import lotto.model.LottoTicket;
import lotto.view.InputView;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.printLottoTicket;
import static lotto.view.OutputView.printPurchaseAmount;

public class LottoController {
    public void run() {
        Deposit deposit = makeDeposit();
        LottoTicket lottoTicket = purchaseLottoTicket(deposit);
        LottoReader lottoReader = drawLotto();
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
        LottoTicket lottoTicket = LottoMachine.issue(purchaseAmount);
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
