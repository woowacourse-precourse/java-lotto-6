package lotto.domain;

import lotto.constant.LottoConfig;

import java.util.List;

import static lotto.constant.ErrorMessage.*;

public class BonusLotto {
    private static final int NUMBER_ZERO = 0;
    private static final String BLANK = " ";

    private final int bonusNumber;

    public BonusLotto(String inputBonusNumber, List<Integer> winnerNumber) {
        validate(inputBonusNumber, winnerNumber);
        this.bonusNumber = Integer.parseInt(inputBonusNumber);
    }

    public int getBonusLotto() {
        return this.bonusNumber;
    }

    private void validate(String bonusNumber, List<Integer> winnerNumber) {
        validateSpace(bonusNumber);
        validateNumber(bonusNumber);
        validateFirstNumber(bonusNumber);
        validateRange(bonusNumber);
        validateDuplicate(bonusNumber, winnerNumber);
    }

    private void validateSpace(String bonusNumber) {
        if(bonusNumber.contains(BLANK)){
            throw new IllegalArgumentException(ERROR_CONTAIN_SPACE.toString());
        }
    }

    private void validateNumber(String bonusNumber) {
        if (!isNumeric(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER.toString());
        }
    }

    private boolean isNumeric(String str) {
        return str.matches(LottoConfig.IS_NUMBER);
    }

    private void validateFirstNumber(String bonusNumber) {
        int firstNumber = bonusNumber.charAt(NUMBER_ZERO) - '0';
        if(firstNumber == NUMBER_ZERO){
            throw new IllegalArgumentException(ERROR_NOT_FIRST_ZERO.toString());
        }
    }

    private void validateRange(String bonusNumber) {
        int number = Integer.parseInt(bonusNumber);
        if (number < LottoConfig.MIN_RANGE || number > LottoConfig.MAX_RANGE) {
            throw new IllegalArgumentException(ERROR_LOTTO_RANGE.toString());
        }
    }

    private void validateDuplicate(String bonusNumber, List<Integer> winnerNumber) {
        int number = Integer.parseInt(bonusNumber);
        if (winnerNumber.contains(number)) {
            throw new IllegalArgumentException(ERROR_LOTTO_DUPLICATE.toString());
        }
    }
}
