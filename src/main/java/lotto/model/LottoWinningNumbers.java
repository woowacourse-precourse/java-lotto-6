package lotto.model;

import java.util.List;

public class LottoWinningNumbers extends Lotto{
    private int bonusNumber;

    public LottoWinningNumbers(List<Integer> numbers, final int bonusNumber) {
        super(numbers);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(final int bonusNumber) {
        validBonusNumberRange(bonusNumber);
        isDuplicatedWithLottoNumber(bonusNumber);
    }

    private void isDuplicatedWithLottoNumber(int bonusNumber) {
        if (getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("로또 번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }

    private static void validBonusNumberRange(int bonusNumber) {
        if (!(bonusNumber >= MIN_RANGE && bonusNumber <= MAX_RANGE)) {
            throw new IllegalArgumentException("보너스 번호도 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
