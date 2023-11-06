package lotto.controller.inputController;

import lotto.view.inputView.LottoBonusWinningNumberInput;
import lotto.view.inputView.LottoWinningNumberInput;
import java.util.List;

public class WinningNumberController {

    private final LottoWinningNumberInput winningNumberInput;
    private final LottoBonusWinningNumberInput bonusNumberInput;

    public WinningNumberController() {
        this.winningNumberInput = new LottoWinningNumberInput();
        this.bonusNumberInput = new LottoBonusWinningNumberInput();
    }

    public List<Integer> getWinningNumbers() {
        return winningNumberInput.requestWinningNumbers();
    }

    public int getBonusNumber() {
        return bonusNumberInput.requestBonusNumber();
    }
}
