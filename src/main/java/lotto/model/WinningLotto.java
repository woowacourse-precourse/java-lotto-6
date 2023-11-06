package lotto.model;

import java.util.List;

public class WinningLotto extends Lotto{
    public WinningLotto(List<Integer> numbers, Integer bonusNumber) {
        super(numbers);
        validateBonusNumber(bonusNumber);
    }

    private void validateBonusNumber(Integer bonusNumber) {
        vaildateOutOfRangeBonusNumber(bonusNumber);
    }

    private void vaildateOutOfRangeBonusNumber(Integer bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 지정된 범위안의 숫자만 가질 수 있습니다 범위 "
                    + MIN_LOTTO_NUMBER + "~" + MAX_LOTTO_NUMBER);
        }
    }
}
