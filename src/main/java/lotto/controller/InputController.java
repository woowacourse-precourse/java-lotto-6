package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import lotto.utils.Parser;
import lotto.view.InputView;

public class InputController {
    private final InputView inputView;

    public InputController(InputView inputView) {
        this.inputView = inputView;
    }

    public int askBudget() {
        String budget = inputView.scanBudget();
        return createBudget(budget);
    }

    public WinningLotto askWinningLotto() {
        String winningNumbers = inputView.scanWinningNumbers();
        String bonusNumber = inputView.scanBonusNumber();
        return new WinningLotto(createWinningNumbers(winningNumbers), createBonusNumber(bonusNumber));
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