package lotto.controller;

import lotto.converter.Converter;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.PurchaseAmount;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class InputController {

    private final Converter<String, Integer> converter;

    public InputController(Converter<String, Integer> converter) {
        this.converter = converter;
    }

    public PurchaseAmount getPurchaseAmount(InputView inputView, OutputView outputView) {
        while (true) {
            try {
                return readPurchaseAmount(inputView);
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception);
            }
        }
    }

    private PurchaseAmount readPurchaseAmount(InputView inputView) {
        Integer number = converter.convert(inputView.readPurchaseAmount());
        return PurchaseAmount.of(number);
    }

    public WinningLotto getWinningLotto(InputView inputView, OutputView outputView) {
        Lotto lotto = getWinningNumbers(inputView, outputView);
        while (true) {
            try {
                Bonus bonus = getBonusNumber(inputView, outputView);
                return new WinningLotto(lotto, bonus);
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception);
            }
        }
    }

    private Lotto getWinningNumbers(InputView inputView, OutputView outputView) {
        while (true) {
            try {
                return readWinningNumbers(inputView);
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception);
            }
        }
    }

    private Lotto readWinningNumbers(InputView inputView) {
        List<Integer> numbers = Arrays.stream(inputView.readWinningNumbers().split(","))
                .map(converter::convert)
                .toList();
        return new Lotto(numbers);
    }

    private Bonus getBonusNumber(InputView inputView, OutputView outputView) {
        while (true) {
            try {
                return readBonusNumber(inputView);
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception);
            }
        }
    }

    private Bonus readBonusNumber(InputView inputView) {
        Integer number = converter.convert(inputView.readBonusNumber());
        return new Bonus(number);
    }
}
