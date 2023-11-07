package lotto.domain;

import static lotto.utils.ErrorMessage.IS_BONUS_NUMBER_DUPLICATED;

import java.util.Collections;

public class BonusNumber extends LottoNumber {
    private static final int BONUS_NUMBER_SIZE = 1;
    public BonusNumber(int bonusNumber, Lotto winningNumbers) {
        super(bonusNumber);
        validate(bonusNumber,winningNumbers);
    }

    private void validate(int number,Lotto winningNumbers) {
        isBonusNumberDuplicated(number, winningNumbers);
    }

    private void isBonusNumberDuplicated(int number, Lotto winningNumbers) {
        if(winningNumbers.containsNumber(number)){
            throw new IllegalArgumentException(IS_BONUS_NUMBER_DUPLICATED.getMessage());
        }
    }
}
