package lotto;

import lotto.util.Constants;

import java.util.List;

public class WinningLotto extends Lotto {
    private int bonusNum;

    public WinningLotto(List<Integer> numbers, int bonusNum) {
        super(numbers);
        validateBonusNum(bonusNum);
        this.bonusNum = bonusNum;
    }

    private void validateBonusNum(int bonusNum) {
        //bonus 숫자가 중복되는경우
        if (getNumbers().contains(bonusNum)) {
            throw new IllegalArgumentException(Constants.ERROR_LOTTO_DUPLICATE_NUMBER);
        }
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
