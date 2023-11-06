package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {
    private static final int WINNING_LOTTO_SIZE = 7;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String NOT_WINNING_LOTTO_SIZE = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 번호여야 합니다.";
    private static final String NOT_BONUS_NUMBER_RANGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";

    private final Lotto winningNumbers;
    private final Integer bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, Integer bonusNumber) {
        this.winningNumbers = new Lotto(winningNumbers);

        validate(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> winningNumbers, Integer bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateNoBonusNumber(winningNumbers, bonusNumber);
    }

    private void validateNoBonusNumber(List<Integer> winningNumbers, Integer bonusNumber) {
        Set<Integer> noBonusNumbers = new HashSet<>(winningNumbers);
        noBonusNumbers.add(bonusNumber);
        if (noBonusNumbers.size() != WINNING_LOTTO_SIZE) {
            throw new IllegalArgumentException(NOT_WINNING_LOTTO_SIZE);
        }
    }

    private void validateBonusNumberRange(Integer bonusNumber) {
        if (!(MIN_NUMBER <= bonusNumber && bonusNumber <= MAX_NUMBER)) {
            throw new IllegalArgumentException(NOT_BONUS_NUMBER_RANGE);
        }
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
