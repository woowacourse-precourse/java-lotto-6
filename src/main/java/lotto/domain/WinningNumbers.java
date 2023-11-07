package lotto.domain;

import java.util.List;
import lotto.view.InputView;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(InputView inputView) {
        this.winningNumbers = inputView.insertWinningNumbers();
        this.bonusNumber = inputView.insertBonusNumber();
    }

}
