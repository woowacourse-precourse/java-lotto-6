package lotto.controller;

import lotto.domain.*;
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

        Money money = loop(this::getMoney);
        outputView.newline();

        LottoPack lottoPack = LottoPack.createLottoPack(money.count());
        outputView.printLottoPack(lottoPack);
        outputView.newline();

        Result result = getResult();
        outputView.newline();

        LottoStatistics lottoStatistics = lottoPack.calculate(result);
        outputView.printResult(lottoStatistics);

        IncomeRate incomeRate = new IncomeRate(money.getPrice(), lottoStatistics.getIncome());
        outputView.printIncomeRate(incomeRate);

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

    private Result getResult() {
        WinningNumbers winningNumbers = loop(this::getWinningNumbers);
        outputView.newline();
        return loop(() -> new Result(winningNumbers, loop(this::getBonusNumber)));
    }

    private WinningNumbers getWinningNumbers() {
        outputView.printGetWinningNumbers();
        return WinningNumbers.createWinningNumbers(inputView.getNumbers());
    }

    private BonusNumber getBonusNumber() {
        outputView.printGetBonusNumber();
        return new BonusNumber(inputView.getNumber());
    }

}
