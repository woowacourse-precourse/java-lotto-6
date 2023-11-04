package lotto.validator;

import lotto.message.ErrorMessage;

import java.util.*;

public class InputValidator {

    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;
    private static final int LOTTO_LIMIT_VALUE = 6;

    public long parseLong(String requestNumber) {
        long number;
        try {
            number = Long.parseLong(requestNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_FORMAT.getMessage());
        }
        return number;
    }

    public int parseInt(String requestNumber) {
        int number;
        try {
            number = Integer.parseInt(requestNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_FORMAT.getMessage());
        }
        return number;
    }

    public void validatePositiveNumber(long number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_LESS_THAN_ZERO.getMessage());
        }
    }

    public void validateLottoNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateLottoNumberRange(number);
        }
    }

    public void validateLottoNumberRange(int number) {
        if (isLottoNumberRange(number)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private boolean isLottoNumberRange(int number) {
        return number < START_LOTTO_NUMBER || number > END_LOTTO_NUMBER;
    }

    public void validateLottoSize(List<Integer> lotto) {
        if (LOTTO_LIMIT_VALUE != lotto.size()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    public void validateBonusNumberMatch(int bonusNumber, List<Integer> numbers){
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_MATCH.getMessage());
        }
    }

}
