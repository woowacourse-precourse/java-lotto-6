package lotto.domain;

import java.util.Collections;

public class BonusNumber extends LottoNumber {
    int bonusNumber;
    private static final int BONUS_NUMBER_SIZE = 1;
    public BonusNumber(int bonusNumber) {
        super(bonusNumber);
        validate(bonusNumber);
    }

    private void validate(int numbers) {
        isLottoSizeValid(Collections.singletonList(numbers), BONUS_NUMBER_SIZE);
    }

}
