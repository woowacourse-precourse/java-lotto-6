package lotto.controller;

import lotto.domain.*;
import lotto.view.Input;
import lotto.view.Output;

import java.util.Map;

public class LottoController {

    private final Input input = new Input();
    private final Output output = new Output();
    private final LottoMachine lottoMachine = new LottoMachine();

    public void run() {
        output.showMoneyInputMessage();
        Money money = repeatMakeMoney();

        LottoTickets lottoTickets = lottoMachine.buy(money);
        output.showLottoTickets(lottoTickets);

        LottoChecker lottoChecker = makeLottoChecker();
        Map<Rank, Integer> winningResult = lottoChecker.checkWinningResult(lottoTickets);
        double totalReturn = lottoChecker.calculateTotalReturn(money);
        output.showWinningStats(winningResult, totalReturn);
    }

    private Money repeatMakeMoney() {
        try {
            return new Money(toInt(input.readMoney()));
        } catch (IllegalArgumentException e) {
            output.showError(e.getMessage());
            return repeatMakeMoney();
        }
    }

    private LottoChecker makeLottoChecker() {
        output.showWinningNumbersInputMessage();
        Lotto winningLotto = repeatMakeWinningLotto();

        output.showBonusNumberInputMessage();
        Bonus bonus = repeatMakeBonus();

        return new LottoChecker(winningLotto, bonus);
    }

    private Lotto repeatMakeWinningLotto() {
        try {
            return lottoMachine.makeWinningLotto(input.readWinningNumbers());
        } catch (IllegalArgumentException e) {
            output.showError(e.getMessage());
            return repeatMakeWinningLotto();
        }
    }

    private Bonus repeatMakeBonus() {
        try {
            return new Bonus(toInt(input.readBonusNumber()));
        } catch (IllegalArgumentException e) {
            output.showError(e.getMessage());
            return repeatMakeBonus();
        }
    }

    private int toInt(String number) {
        return Integer.parseInt(number);
    }
}
