package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Budget;
import lotto.model.lotto.BonusNumber;
import lotto.model.lotto.WinningLotto;
import lotto.validator.InputValidator;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    private Budget getPurchasePrice() {
        while (true) {
            try {
                String inputPrice = inputView.inputPurchasePrice();
                InputValidator.validateInputPrice(inputPrice);
                return new Budget(Integer.parseInt(inputPrice));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningLotto getWinningLotto() {
        while (true) {
            try {
                String inputWinningNumber = inputView.inputWinningNumbers();
                List<Integer> numbers = parseListFromNumbers(inputWinningNumber);
                return new WinningLotto(numbers);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BonusNumber getBonusNumber(WinningLotto winningLotto) {
        while (true) {
            try {
                String inputBonusNumber = inputView.inputBonusNumber();
                InputValidator.validateBonusNumber(inputBonusNumber);
                return new BonusNumber(Integer.parseInt(inputBonusNumber), winningLotto);
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
        }
    }

    private List<Integer> parseListFromNumbers(String inputNumbers) {
        return Arrays.stream(inputNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
