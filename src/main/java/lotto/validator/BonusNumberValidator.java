package lotto.validator;

import java.util.List;

public class BonusNumberValidator extends Validator {
    public static void haveValidateRange(String string) {
        isLottoNumberRange(string);
    }

    public static void haveDuplicateNumber(List<Integer> lotto, String bonusNumber) {
        if (lotto.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException();
        }
    }
}
