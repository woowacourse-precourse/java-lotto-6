package lotto.controller;

import lotto.converter.StringToInteger;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.PurchaseAmount;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class InputController {

    private final InputView inputView;
    private final OutputView outputView;
    private final StringToInteger integerConverter;

    public InputController(InputView inputView, OutputView outputView, StringToInteger integerConverter) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.integerConverter = integerConverter;
    }

    public PurchaseAmount getPurchaseAmount() {
        while (true) {
            try {
                return readPurchaseAmount();
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception);
            }
        }
    }

    private PurchaseAmount readPurchaseAmount() {
        Integer number = integerConverter.convert(inputView.readPurchaseAmount());
        return PurchaseAmount.of(number);
    }

    public WinningLotto getWinningLotto() {
        Lotto lotto = getWinningNumbers();
        while (true) {
            try {
                Bonus bonus = getBonusNumber();
                return new WinningLotto(lotto, bonus);
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception);
            }
        }
    }

    private Lotto getWinningNumbers() {
        while (true) {
            try {
                return readWinningNumbers();
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception);
            }
        }
    }

    private Lotto readWinningNumbers() {
        List<Integer> numbers = Arrays.stream(inputView.readWinningNumbers().split(","))
                .map(integerConverter::convert)
                .toList();
        return new Lotto(numbers);
    }

    private Bonus getBonusNumber() {
        while (true) {
            try {
                return readBonusNumber();
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception);
            }
        }
    }

    private Bonus readBonusNumber() {
        Integer number = integerConverter.convert(inputView.readBonusNumber());
        return new Bonus(number);
    }
}
