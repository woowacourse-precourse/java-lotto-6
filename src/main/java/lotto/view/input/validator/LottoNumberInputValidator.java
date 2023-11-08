package lotto.view.input.validator;

import java.util.*;

import static lotto.constants.LottoRule.STANDARD;
import static lotto.message.ErrorMessage.*;

public class LottoNumberInputValidator {

    public int parseInt(String requestNumber) {
        int number;
        try {
            number = Integer.parseInt(requestNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_FORMAT.getMessage());
        }
        return number;
    }

    public void validateLottoNumberRange(int number) {
        if (isLottoNumberRange(number)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private boolean isLottoNumberRange(int number) {
        return number < STANDARD.getStartNumber() || number > STANDARD.getLastNumber();
    }

    public void validateBonusNumberMatch(int bonusNumber, List<Integer> numbers){
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_MATCH.getMessage());
        }
    }

    public long parseLong(String requestNumber) {
        long number;
        try {
            number = Long.parseLong(requestNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_AMOUNT_FORMAT.getMessage());
        }
        return number;
    }

}
