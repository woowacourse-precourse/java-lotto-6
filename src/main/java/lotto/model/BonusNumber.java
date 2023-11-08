package lotto.model;
import lotto.util.ExceptionUtils;
import static lotto.model.Constant.*;
public class BonusNumber {
    private final int bonusNum;

    public BonusNumber(int bonusNum) {
        isInBonusNumber(bonusNum);
        this.bonusNum = bonusNum;
    }
    public static void isInBonusNumber(int bonusNum) {
        if(bonusNum < LOTTO_MIN_NUMBER || bonusNum > LOTTO_MAX_NUMBER)
            throw new IllegalArgumentException(ExceptionUtils.LOTTO_RANGE_ERROR.getErrorMessage());
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
