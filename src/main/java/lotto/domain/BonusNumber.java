package lotto.domain;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoRule;

public class BonusNumber {
    int bonusNumber;

    public BonusNumber(String inputBonusNumber) {
        validateInputBonusNumber(inputBonusNumber);
        bonusNumber = Integer.parseInt(inputBonusNumber);
    }

    public void validateInputBonusNumber(String inputValue) {
        validateOnlyNumber(inputValue);
        validateBetweenMinNumberAndMaxNumber(inputValue);
    }

    private void validateOnlyNumber(String content) {
        if(!content.matches("[0-9]+")) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_IS_NOT_NUMBER.getMessage());
        }
    }

    private int validateBetweenMinNumberAndMaxNumber(String content) {
        int result = Integer.parseInt(content);
        if(result < LottoRule.LOTTO_MIN_NUMBER.getNumber() || LottoRule.LOTTO_MAX_NUMBER.getNumber() < result) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_IS_NOT_INTERVAL_VALUE.getMessage());
        }
        return result;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
