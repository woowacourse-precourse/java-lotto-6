package lotto.controller;

import lotto.domain.LottoPack;
import lotto.domain.Money;
import lotto.domain.WinningNumber;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

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
        outputView.newline();
        WinningNumber bonusNumber = loop(this::getBonusNumber);

    }

    private LottoPack buyLottoPack() {
        Money money = loop(this::getMoney);
        outputView.newline();
        LottoPack lottoPack = LottoPack.createLottoPack(money.count());
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

    private WinningNumbers getWinningNumbers() {
        outputView.printGetWinningNumbers();
        return WinningNumbers.createWinningNumbers(inputView.getNumbers());
    }

    private WinningNumber getBonusNumber() {
        outputView.printGetBonusNumber();
        return new WinningNumber(inputView.getNumber());
    }

}
