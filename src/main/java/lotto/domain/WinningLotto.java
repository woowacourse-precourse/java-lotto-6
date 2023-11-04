package lotto.domain;

import static lotto.util.ConstantUtils.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.ConstantUtils;

public class WinningLotto {
    private static final int WINNING_LOTTO_SIZE_CRITERION = 7;
    private List<Number> winningNumbers;
    private Number bonusNumber;

    public WinningLotto(List<Number> winningNumbers, Number bonusNumber) {
        validateNoDuplicatedWinningNumbers(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateNoDuplicatedWinningNumbers(List<Number> winningNumbers,
        Number bonusNumber) {
        winningNumbers.add(bonusNumber);
        Set<Number> set = new HashSet<>(winningNumbers);
        if (set.size() != WINNING_LOTTO_SIZE_CRITERION) {
            throw new IllegalArgumentException();
        }
    }
}
