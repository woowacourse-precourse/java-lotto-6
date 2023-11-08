package lotto.model;

import java.util.List;

public class LottoWinningNumbers extends Lotto {
    public static final String ERROR_MESSAGE_DUPLICATE_BONUS_NUMBER = "로또 번호와 보너스 번호는 중복될 수 없습니다.";
    public static final String ERROR_MESSAGE_INVALID_BONUS_NUMBER_RANGE = "보너스 번호도 1부터 45 사이의 숫자여야 합니다.";
    private int bonusNumber;

    public LottoWinningNumbers(List<Integer> numbers, int bonusNumber) {
        super(numbers);

        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonus() {
        return bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        validBonusNumberRange(bonusNumber);
        isDuplicatedWithLottoNumber(bonusNumber);
    }

    private void isDuplicatedWithLottoNumber(int bonusNumber) {
        if (getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATE_BONUS_NUMBER);
        }
    }

    private void validBonusNumberRange(int bonusNumber) {
        if (!(bonusNumber >= MIN_RANGE && bonusNumber <= MAX_RANGE)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_BONUS_NUMBER_RANGE);
        }
    }
}