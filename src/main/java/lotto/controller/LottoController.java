package lotto.controller;

import lotto.domain.LottoPack;
import lotto.domain.Money;
import lotto.domain.WinningNumber;
import lotto.domain.WinningNumbers;
import util.NumberGenerator.INumberGenerator;
import util.NumberGenerator.NumberGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {

        LottoPack lottoPack = buyLottoPack();

        outputView.newline();

        WinningNumbers winningNumbers = loop(this::getWinningNumbers);

    }

    private LottoPack buyLottoPack() {

        Money money = loop(this::getMoney);

        outputView.newline();

        LottoPack lottoPack = getLottoPack(money);
        outputView.printLottoPack(lottoPack);

        return lottoPack;

    }

    private <T> T loop(Supplier<T> function) {
        while (true) {
            try {
                return function.get();
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
        }
    }

    private Money getMoney() {
        outputView.printGetMoney();
        int number = inputView.getNumber();
        return new Money(number);
    }

    private LottoPack getLottoPack(Money money) {
        INumberGenerator numberGenerator = new NumberGenerator();
        return new LottoPack(money.count(), numberGenerator);
    }

    private WinningNumbers getWinningNumbers() {
        outputView.printGetWinningNumbers();
        List<WinningNumber> winningNumbers = inputView.getNumbers().stream()
                .map(WinningNumber::new)
                .toList();
        return new WinningNumbers(winningNumbers);
    }

}
