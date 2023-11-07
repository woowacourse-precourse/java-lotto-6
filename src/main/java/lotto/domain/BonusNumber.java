package lotto.domain;

import static lotto.settings.ErrorMessage.DUPLICATE_NUM;
import static lotto.settings.ErrorMessage.INVALID_RANGE;

public class BonusNumber {

    private final int number;

    private BonusNumber(int number) {
        this.number = number;
    }

    public static BonusNumber from(Lotto winningLotto, int number){
        validateRange(number);
        validateBonusNumInLotto(winningLotto,number);
        return new BonusNumber(number);
    }

    private static void validateRange(int number) {
        if(number<1 || number>45){
            throw new IllegalArgumentException(INVALID_RANGE.getMessage());
        }
    }

    private static void validateBonusNumInLotto(Lotto lotto, int bonusNumber) {
        if(lotto.has(bonusNumber)){
            throw new IllegalArgumentException(DUPLICATE_NUM.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }
}
