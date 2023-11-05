package lotto.domain;

import static lotto.settings.ErrorMessage.INVALID_RANGE;

public class BonusNumber {

    private final int number;

    private BonusNumber(int number) {
        this.number = number;
    }

    public static BonusNumber from(int number){
        validateRange(number);
        return new BonusNumber(number);
    }

    private static void validateRange(int number) {
        if(number<1 || number>45){
            throw new IllegalArgumentException(INVALID_RANGE.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }
}
