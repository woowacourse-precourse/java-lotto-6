package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.controller.validator.InputValidator;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import lotto.utils.Parser;
import lotto.view.InputView;

public class InputController {
    private final InputView inputView;
    private final InputValidator inputValidator;

    public InputController(InputView inputView, InputValidator inputValidator) {
        this.inputView = inputView;
        this.inputValidator = inputValidator;
    }

    public int askBudget() {
        while (true) {
            try {
                String budget = inputView.scanBudget();
                inputValidator.validateBudgetInput(budget);
                return createBudget(budget);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public WinningLotto askWinningLotto() {
        Lotto winningNumbers = askWinningNumbers();
        int bonusNumber = askBonusNumber();
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    public Lotto askWinningNumbers() {
        while (true) {
            try {
                String winningNumbers = inputView.scanWinningNumbers();
                inputValidator.validateLottoTicketInput(winningNumbers);
                return createWinningNumbers(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int askBonusNumber() {
        while (true) {
            try {
                String bonusNumber = inputView.scanBonusNumber();
                inputValidator.validateBonusNumberInput(bonusNumber);
                return createBonusNumber(bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int createBudget(String budget) {
        return Integer.parseInt(budget);
    }

    public Lotto createWinningNumbers(String winningNumbers) {
        List<Integer> lotto = new ArrayList<>();
        Parser.parseWithComma(winningNumbers)
                .forEach(number -> lotto.add(Integer.parseInt(number)));
        return new Lotto(lotto);
    }

    public int createBonusNumber(String bonusNumber) {
        return Integer.parseInt(bonusNumber);
    }
}