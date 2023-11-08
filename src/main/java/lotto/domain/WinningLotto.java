package lotto.domain;

import java.util.List;
import lotto.view.InputView;

public class WinningLotto {
    private final int THIRD_PRIZE_THRESHOLD = 5;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(InputView inputView) {
        this.winningNumbers = inputView.insertWinningNumbers();
        this.bonusNumber = inputView.insertBonusNumber(winningNumbers);
    }

    public int matchLottoWithWinningOne(Lotto lotto) {
        int count = 0;
        for (int number : winningNumbers) {
            if (lotto.contain(number)) {
                count++;
            }
        }
        if (isSecondPrize(lotto, count)) {
            return -++count;
        }
        return count;
    }

    private boolean isSecondPrize(Lotto lotto, int count) {
        return isThirdPrize(count) && conditionForSecondPrize(lotto);
    }

    private boolean isThirdPrize(int count) {
        return count == THIRD_PRIZE_THRESHOLD;
    }

    private boolean conditionForSecondPrize(Lotto lotto) {
        return lotto.contain(bonusNumber);
    }
}
