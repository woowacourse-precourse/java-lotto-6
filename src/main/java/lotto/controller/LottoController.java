package lotto.controller;

import lotto.config.LottoConfig;
import lotto.domain.Money;
import lotto.domain.Quantity;
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
    }

    private Money parseIntToMoney() {
        return Money.from(input.printAskingBudget());
    }

}
