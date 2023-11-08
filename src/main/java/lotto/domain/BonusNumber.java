package lotto.domain;

import java.util.List;

public class BonusNumber {

    private static final int MIN_BONUS_NUMBER_RANGE = 1;
    private static final int MAX_BONUS_NUMBER_RANGE = 45;

    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberRange(int number) {
        if (isBonusNumberOverRange(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1이상 45이하의 숫자만 입력 가능합니다.");
        }
    }

    private boolean isBonusNumberOverRange(int number) {
        return number < MIN_BONUS_NUMBER_RANGE || number > MAX_BONUS_NUMBER_RANGE;
    }

    public boolean isMatch(List<Integer> buyerLotto) {
        return buyerLotto.contains(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
