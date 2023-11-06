package lotto.validator;

import java.util.List;
import lotto.model.LottoNumber;

public class BonusNumberInputValidator {
    private static final String INPUT_NOT_NUMERIC = "[ERROR] 입력값이 숫자가 아닙니다.";
    private static final String INPUT_NOT_BETWEEN_ONE_AND_FORTY_FIVE = "[ERROR] 입력값이 1과 45 사이여야 합니다.";
    private static final String INPUT_DUPLICATED = "[ERROR] 입력값이 당첨번호와 중복되지 않아야 합니다.";

    public void validate(String input, List<Integer> winningLotto) {
        validateNumberIfNumeric(input);
        validateNumberRange(input);
        validateDuplicateNumber(input, winningLotto);
    }

    private void validateNumberIfNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NOT_NUMERIC);
        }
    }

    private void validateNumberRange(String input) {
        int bonusNumber = Integer.parseInt(input);
        if (!LottoNumber.isInRange(bonusNumber)) {
            throw new IllegalArgumentException(INPUT_NOT_BETWEEN_ONE_AND_FORTY_FIVE);
        }
    }

    private void validateDuplicateNumber(String input, List<Integer> winningLotto) {
        int bonusNumber = Integer.parseInt(input);
        if (hasBonusNumber(bonusNumber, winningLotto)) {
            throw new IllegalArgumentException(INPUT_DUPLICATED);
        }
    }

    private boolean hasBonusNumber(Integer bonusNumber, List<Integer> winningLotto) {
        return winningLotto.contains(bonusNumber);
    }
}
