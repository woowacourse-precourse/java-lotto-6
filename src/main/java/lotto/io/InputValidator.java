package lotto.io;

import lotto.domain.Constants;

import java.util.List;

public class InputValidator {

    public void validateBonusNumber(String userInput) {
        validateOnlyOneNumber(userInput);
        validateBonusNumberRange(userInput);
    }

    private void validateOnlyOneNumber(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if(!Character.isDigit(userInput.charAt(i))){
                throw new IllegalArgumentException(Constants.ONLY_ONE_NUMBER_MESSAGE);
            }
        }
    }

    private void validateBonusNumberRange(String userInput) {
        int bonusNumber = Integer.parseInt(userInput);
        if (!(bonusNumber >= Constants.LOTTO_MIN_NUM && bonusNumber <= Constants.LOTTO_MAX_NUM)) {
            throw new IllegalArgumentException(Constants.BONUS_NUM_RANGE_MESSAGE);
        }
    }
}
