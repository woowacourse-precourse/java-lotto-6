package lotto.valid;

import lotto.models.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumberValidator extends Validator {

    public static void validate(Lotto lotto, int bonusNumber) throws IllegalArgumentException {
        validateRange(bonusNumber);
        validateDuplicateBonusNumber(lotto, bonusNumber);
    }

    private static void validateDuplicateBonusNumber(Lotto lotto, int validatedBonusNumber) throws IllegalArgumentException {
        if (lotto.getNumbers().contains(validatedBonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

}
