package lotto.valid;

import lotto.models.Lotto;

public class WinNumberValidator extends Validator {

    public static void validate(Lotto lotto, int bonusNumber) throws IllegalArgumentException {
        validateLottoRange(bonusNumber);
        validateDuplicateBonusNumber(lotto, bonusNumber);
    }

    private static void validateDuplicateBonusNumber(Lotto lotto, int validatedBonusNumber) throws IllegalArgumentException {
        if (lotto.getNumbers().contains(validatedBonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

}
