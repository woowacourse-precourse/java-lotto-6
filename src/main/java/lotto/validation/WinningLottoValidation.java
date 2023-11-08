package lotto.validation;

import java.util.List;
import lotto.Lotto;

public class WinningLottoValidation {

    public static void validateDuplicateNumbersAndBonus(Lotto lotto, int bonusNumber) {
        List<Integer> numbers = lotto.getNumbers();
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 lotto번호와 중복되면 안됩니다.");
        }
    }

    public static void ValidateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 각각의 값은 1 ~ 45의 값이여야 합니다.");
        }
    }
}
