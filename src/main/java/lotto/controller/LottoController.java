package lotto.controller;

import lotto.domain.LottoPack;
import lotto.domain.Money;
import util.NumberGenerator.INumberGenerator;
import util.NumberGenerator.NumberGenerator;
import view.InputView;
import view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {

        Money money = getMoney();

        LottoPack lottoPack = getLottoPack(money);

    }

    private Money getMoney() {
        while (true) {
            try {
                outputView.printGetMoney();
                int number = inputView.getNumber();
                return new Money(number);
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
        }
    }

    private LottoPack getLottoPack(Money money) {
        INumberGenerator numberGenerator = new NumberGenerator();
        return new LottoPack(money.count(), numberGenerator);
    }

}
