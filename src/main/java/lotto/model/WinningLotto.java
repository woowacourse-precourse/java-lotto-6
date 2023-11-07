package lotto.model;

import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;

public class WinningLotto {

    private WinningNumber winningNumber;
    private BonusNumber bonusNumber;

    public WinningLotto() {
        settingWinningLotto();
    }

    public WinningNumber getWinningNumber() {
        return winningNumber;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }

    private void settingWinningLotto() {
        this.winningNumber = settingWinningNumber();
        this.bonusNumber = settingBonusNumber();
    }

    private BonusNumber settingBonusNumber() {
        do {
            try {
                int bonusNumber = readBonusNumber();
                return new BonusNumber(bonusNumber, this.winningNumber);
            } catch (IllegalArgumentException e) {
                OutputView.printExceptionMessage(e.getMessage());
            }
        } while (true);
    }

    private WinningNumber settingWinningNumber() {
        do {
            try {
                return new WinningNumber(readWinningNumbers());
            } catch (IllegalArgumentException e) {
                OutputView.printExceptionMessage(e.getMessage());
            }
        } while (true);
    }


    private List<Integer> readWinningNumbers() {
        return InputView.readWinningNumbers();
    }

    private int readBonusNumber() {
        return InputView.readBonusNumber();
    }
}
