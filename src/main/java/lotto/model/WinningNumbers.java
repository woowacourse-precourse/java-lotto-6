package lotto.model;

import java.util.HashSet;
import lotto.exception.CustomIllegalArgumentException;
import lotto.exception.ErrorCode;

public class WinningNumbers {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private final Lotto mainNumbers;
    private final int bonusNumber;

    public WinningNumbers(Lotto mainNumbers, int bonusNumber) {
        validate(mainNumbers, bonusNumber);
        this.mainNumbers = mainNumbers;
        this.bonusNumber = bonusNumber;
    }

    public HashSet<Integer> assembleWinningNumbers() {
        HashSet<Integer> winningNumbers = new HashSet<>(mainNumbers.getNumbers());
        winningNumbers.add(bonusNumber);
        return winningNumbers;
    }

    public int calculateMatchCount(Lotto lotto) {
        HashSet<Integer> lottoNumbers = new HashSet<>(lotto.getNumbers());
        HashSet<Integer> winningNumbers = new HashSet<>(mainNumbers.getNumbers());

        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean isBonusMatch(Lotto lotto) {
        return lotto.hasBonusNumber(bonusNumber);
    }

    private void validate(Lotto mainNumbers, int bonusNumber) {
        validateBonusNumberDuplicate(mainNumbers, bonusNumber);
        validateBonusNumberRange(bonusNumber);
    }

    private void validateBonusNumberDuplicate(Lotto mainNumbers, int bonusNumber) {
        if (mainNumbers.hasBonusNumber(bonusNumber)) {
            throw new CustomIllegalArgumentException(ErrorCode.BONUS_NUMBER_DUPLICATED);
        }
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new CustomIllegalArgumentException(ErrorCode.BONUS_NUMBER_OUT_OF_RANGE);
        }
    }
}
