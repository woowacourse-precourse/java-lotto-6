package lotto.domain;

import java.util.List;

import static lotto.constant.ErrorMessage.*;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(String bonusNumber, List<Integer> lottoNumber) {
        validate(bonusNumber, lottoNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private void validate(String bonusNumber, List<Integer> lottoNumber) {
        validateIsDigit(bonusNumber);
        validateNumberRange(bonusNumber);
        validateDuplication(bonusNumber, lottoNumber);
    }

    private void validateDuplication(String bonusNumber, List<Integer> lottoNumber) {
        int convertedBonusNumber = Integer.parseInt(bonusNumber);
        if(lottoNumber.contains(convertedBonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_AND_LOTTO_NUMBER_DUPLICATED_WARNING);
        }
    }

    private void validateNumberRange(String bonusNumber) {
        int convertedBonusNumber = Integer.parseInt(bonusNumber);
        if(convertedBonusNumber < 1 || convertedBonusNumber > 45) {
            throw new IllegalArgumentException(BONUS_NUMBER_RANGE_WARNING);
        }
    }

    private void validateIsDigit(String bonusNumber) {
        try{
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(BONUS_NUMBER_INCLUDE_STRING_WARNING);
        }
    }
}
