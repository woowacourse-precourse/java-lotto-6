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
        return Integer.parseInt(budget);
    }

    public WinningLotto askWinningLottoTicket() {
        Lotto winningNumbers = askWinningNumbers();
        int bonusNumber = askBonusNumber();
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    public Lotto askWinningNumbers() {
        String userInput = inputView.scanWinningNumbers();

        List<Integer> lotto = new ArrayList<>();
        Parser.parseWithComma(userInput)
                .forEach(number -> lotto.add(Integer.parseInt(number)));
        return new Lotto(lotto);
    }

    public int askBonusNumber() {
        return Integer.parseInt(inputView.scanBonusNumber());
    }
}