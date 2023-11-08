package lotto.model;

import lotto.util.StringUtils;

public class BonusNumber {
    private final int number;

    public BonusNumber(String inputBonusNumber) {
        validate(inputBonusNumber);
        this.number = Integer.parseInt(inputBonusNumber);
    }

    private void validate(String inputBonusNumber) {
        validateNumberFormat(inputBonusNumber);
        validateRangeOverBonusNumber(inputBonusNumber);
    }

    private void validateNumberFormat(String inputBonusNumber) {
        if (!StringUtils.isNumeric(inputBonusNumber)) {
            throw new IllegalArgumentException(StringUtils.createErrorMessage("보너스 번호는 숫자만 입력해주세요."));
        }
    }

    private void validateRangeOverBonusNumber(String inputBonusNumber) {
        int inputNumber = Integer.parseInt(inputBonusNumber);
        if (inputNumber < Constants.LOTTO_MIN_NUMBER.constants || inputNumber > Constants.LOTTO_MAX_NUMBER.constants) {
            throw new IllegalArgumentException();
        }
    }

    public int getNumber() {
        return number;
    }
}
