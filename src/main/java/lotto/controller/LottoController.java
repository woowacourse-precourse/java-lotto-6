package lotto.controller;

import lotto.converter.Converter;
import lotto.converter.StringToInteger;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.LottoPrize;
import lotto.model.PurchaseAmount;
import lotto.model.Result;
import lotto.model.WinningLotto;
import lotto.service.Calculator;
import lotto.service.LottoIssuer;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Converter<String, Integer> integerConverter = new StringToInteger(); //TODO: 이게 최선인가


    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        PurchaseAmount amount = readPurchaseAmount();
        LottoIssuer lottoIssuer = LottoIssuer.of(amount);
        List<Lotto> boughtLotto = lottoIssuer.issueLotto();
        outputView.printBoughtLotto(boughtLotto);
        WinningLotto winningLotto = readWinningLottoAndBonus();
        List<LottoPrize> lottoPrizes = new ArrayList<>();
        for (Lotto bought : boughtLotto) {
            lottoPrizes.add(winningLotto.from(bought));
        }
        Result result = Result.from(lottoPrizes);
        outputView.printWinningStatistics(result);
        Calculator calculator = new Calculator();
        Double totalReturn = calculator.calculatePrize(lottoPrizes);
        outputView.printTotalReturn(totalReturn);
    }

    private WinningLotto readWinningLottoAndBonus() {
        Lotto lotto = readWinningNumbers();
        return readWinning(lotto);
    }

    private WinningLotto readWinning(Lotto lotto) {
        try {
            Bonus bonus = readBonusNumber();
            return new WinningLotto(lotto, bonus);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception);
            return readWinning(lotto);
        }
    }

    private Lotto readWinningNumbers() {
        try {
            List<Integer> numbers = Arrays.stream(inputView.readWinningNumbers().split(","))
                    .map(integerConverter::convert)
                    .toList();
            return new Lotto(numbers);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception);
            return readWinningNumbers();
        }
    }

    private Bonus readBonusNumber() {
        try {
            Integer number = integerConverter.convert(inputView.readBonusNumber());
            return new Bonus(number);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception);
            return readBonusNumber();
        }
    }

    private PurchaseAmount readPurchaseAmount() {
        try {
            Integer number = integerConverter.convert(inputView.readPurchaseAmount());
            return PurchaseAmount.of(number);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception);
            return readPurchaseAmount();
        }
    }
}
