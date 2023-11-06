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

        Money money = requestMoney();

        LottoPack lottoPack = buildLottoPack(money);

        Result result = requestResult();

        LottoStatistics lottoStatistics = lottoPack.calculate(result);
        IncomeRate incomeRate = new IncomeRate(money.getPrice(), lottoStatistics.getIncome());

        outputView.printResult(lottoStatistics);
        outputView.printIncomeRate(incomeRate);

    }

    private Money requestMoney() {
        Money money = loop(this::getMoney);
        outputView.newline();
        return money;
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

    private LottoPack buildLottoPack(Money money) {
        LottoPack lottoPack = LottoPack.createLottoPack(money.count());
        outputView.printLottoPack(lottoPack);
        outputView.newline();
        return lottoPack;
    }

    private Result requestResult() {
        Result result = getResult();
        outputView.newline();
        return result;
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
