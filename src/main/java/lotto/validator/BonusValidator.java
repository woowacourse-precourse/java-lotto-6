package lotto.validator;

import lotto.model.Lotto;
import lotto.utils.FormatUtils;

import java.util.List;
import java.util.regex.Pattern;

public class BonusValidator {
    private static final Pattern BONUS_REGEX = Pattern.compile("^[0-9]+$");

    public static void validate(Lotto lotto, String inputBonusNumber) {
        validateNumeric(inputBonusNumber);
        int bonusNumber = FormatUtils.stringToInteger(inputBonusNumber);
        validateDuplicate(lotto.getNumbers(), bonusNumber);
        validateRange(bonusNumber);
    }

    private static void validateNumeric(String inputBonusNumber) {
        if (!BONUS_REGEX.matcher(inputBonusNumber).matches()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수만 입력 가능합니다.");
        }
    }

    private static void validateDuplicate(List<Integer> winningLottoNumbers, int bonusNumber) {
        if(winningLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호와 중복된 숫자는 입력할 수 없습니다.");
        }
    }

    public static void validateRange(int inputBonusNumber) {
        if(inputBonusNumber < 1 || inputBonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45 사이만 입력 가능합니다.");
        }
    }
}
