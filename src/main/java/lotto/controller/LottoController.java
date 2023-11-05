package lotto.controller;

import lotto.Lotto;
import lotto.config.LottoConfig;
import lotto.domain.BonusNumber;
import lotto.domain.Money;
import lotto.domain.Quantity;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView input;
    private final OutputView output;

    public LottoController() {
        this.input = new InputView();
        this.output = new OutputView();
    }

    public void run() {
        Quantity totalLotteries = Quantity.of(parseIntToMoney(), LottoConfig.PRICE);
        output.printQuantityOfLotteries(totalLotteries);

        Lotto winningNumbers = parseListToLotto();
        BonusNumber bonusNumber = parseIntToBonusNumber();

        WinningLotto.of(winningNumbers, bonusNumber);

    }

    private Money parseIntToMoney() {
        return new Money(input.printAskingBudget());
    }

    private Lotto parseListToLotto() {
        return new Lotto(input.printAskingWinningNumbers());
    }

    private BonusNumber parseIntToBonusNumber() {
        return new BonusNumber(input.printAskingBonusNumber());
    }

}
