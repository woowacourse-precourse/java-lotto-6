package lotto.controller;

import lotto.domain.LottoPack;
import lotto.domain.Money;
import lotto.domain.WinningNumber;
import lotto.domain.WinningNumbers;
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
        return new Money(inputView.getNumber());
    }

    private LottoPack getLottoPack(Money money) {
        return new LottoPack(money.count(), new NumberGenerator());
    }

    private WinningNumbers getWinningNumbers() {
        outputView.printGetWinningNumbers();
        List<WinningNumber> winningNumbers = inputView.getNumbers().stream()
                .map(WinningNumber::new)
                .toList();
        return new WinningNumbers(winningNumbers);
    }

}
