package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoWallet;
import lotto.domain.LottoWalletGenerator;
import lotto.domain.Money;
import lotto.domain.MoneyRate;
import lotto.domain.TotalAmount;
import lotto.domain.WinningLotto;
import lotto.view.BonusNumberInputView;
import lotto.view.MoneyInputView;
import lotto.view.OutputView;
import lotto.view.LottoInputView;

public class LottoController {
    private final OutputView outputView;

    public LottoController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void start() {
        Money money = getMoney();
        LottoWallet lottoWallet = buyLotto(money.getTicket());
        WinningLotto winningLotto = getWinningLotto();

        LottoResult lottoResult = new LottoResult();
        lottoResult.countPrizes(lottoWallet, winningLotto);
        outputView.printPrizeCount(lottoResult.getResult());

        TotalAmount totalAmount = new TotalAmount(lottoResult.getTotalAmount());
        MoneyRate moneyRate = new MoneyRate(totalAmount, money);

        outputView.printMoneyRate(moneyRate.getRate());
    }

    private Money getMoney() {
        MoneyInputView moneyInputView = new MoneyInputView();
        while (true) {
            try {
                outputView.printMoneyInputMessage();
                long moneyInput = moneyInputView.readMoneyInput();
                return new Money(moneyInput);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private LottoWallet buyLotto(long ticket) {
        outputView.println();
        outputView.printTicket(ticket);
        List<Lotto> wallet = LottoWalletGenerator.generateLottoWallet(ticket);
        outputView.printLottoList(wallet);
        return new LottoWallet(wallet);
    }

    private WinningLotto getWinningLotto() {
        BonusNumberInputView bonusNumberInputView = new BonusNumberInputView();
        outputView.println();
        Lotto lotto = getLotto();
        while (true) {
            try {
                outputView.printBonusNumberInputMessage();
                Integer bonusNumber = bonusNumberInputView.readBonusNumberInput();
                return new WinningLotto(lotto, bonusNumber);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private Lotto getLotto() {
        LottoInputView LottoInputView = new LottoInputView();
        outputView.println();
        while (true) {
            try {
                outputView.printWinningLottoInputMessage();
                List<Integer> winningLotto = LottoInputView.readLottoInput();
                return new Lotto(winningLotto);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

}
