package lotto.controller.inputController;

import lotto.model.validator.LottoWinningNumberValidator;
import lotto.view.inputView.LottoBonusWinningNumberInput;
import lotto.view.inputView.LottoWinningNumberInput;

import java.util.List;

public class LottoWinningNumberController {

    private final LottoWinningNumberInput winningNumberInput;
    private final LottoBonusWinningNumberInput bonusNumberInput;

    public LottoWinningNumberController() {
        this.winningNumberInput = new LottoWinningNumberInput();
        this.bonusNumberInput = new LottoBonusWinningNumberInput();
    }

    public List<Integer> getWinningNumbers() {
        while (true) {
            try {
                String input = winningNumberInput.requestWinningNumbers();
                return LottoWinningNumberValidator.validateWinningNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getBonusNumber() {
        return bonusNumberInput.requestBonusNumber();
    }
}