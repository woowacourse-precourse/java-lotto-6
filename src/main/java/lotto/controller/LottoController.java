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

        LottoPack lottoPack = buyLottoPack();
        outputView.newline();

        Result result = getResult();
        outputView.newline();

        LottoStatistics lottoStatistics = lottoPack.calculate(result);
        outputView.printResult(lottoStatistics);

        IncomeRate incomeRate = new IncomeRate(lottoPack.getPrice(), lottoStatistics.getIncome());
        outputView.printIncomeRate(incomeRate);

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

    private Result getResult() {

        ResultBuilder resultBuilder = new ResultBuilder();

        loop(() -> getWinningNumbers(resultBuilder));
        outputView.newline();
        loop(() -> getBonusNumber(resultBuilder));

        return resultBuilder.build();

    }

    private ResultBuilder getWinningNumbers(ResultBuilder resultBuilder) {
        outputView.printGetWinningNumbers();
        resultBuilder.setWinningNumbers(WinningNumbers.createWinningNumbers(inputView.getNumbers()));
        return resultBuilder;
    }

    private ResultBuilder getBonusNumber(ResultBuilder resultBuilder) {
        outputView.printGetBonusNumber();
        BonusNumber bonusNumber = new BonusNumber(inputView.getNumber());
        resultBuilder.setBonusNumber(bonusNumber);
        return resultBuilder;
    }

}
