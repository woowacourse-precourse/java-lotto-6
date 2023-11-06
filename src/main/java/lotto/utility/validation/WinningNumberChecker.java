package lotto.utility.validation;

import static lotto.constants.ErrorMessage.DUPLICATED_LOTTO_NUMBER;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;

public class WinningNumberChecker {
    public static void validate(Lotto winnigLotto, BonusNumber bonusNumber) {
        if(bonusNumber.contained(winnigLotto)) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER);
        }
    }
}
