package lotto.util.validate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.util.constant.InvalidConstant.*;

public class InputValidate {

    public static int validateInputFormat(String input) {
        int parseIntInputValue;
        try {
            parseIntInputValue = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_INPUT_FORMAT);
        }
        return parseIntInputValue;
    }

    public static void validateThousandUnitInputFormat(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_THOUSAND_UNIT);
        }
    }

    public static void validateNumberRangeInputFormat(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_INPUT_RANGE);
        }
    }

    public static void validateUniqueInputLottoNumbers(List<Integer> lottoNumbers) {
        Set<Integer> checkingUniqueNumbers = new HashSet<>(lottoNumbers);
        if (checkingUniqueNumbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_UNIQUE_WINNING_NUMBERS);
        }
    }

    public static void validateAmountInputLottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_SIZE_WINNING_NUMBERS);
        }
    }

    public static void validateRangeInputLottoNumbers(List<Integer> lottoNumbers) {
        for (Integer lottoNumber : lottoNumbers) {
            if (!isValidNumberRange(lottoNumber)) {
                throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_RANGE_WINNING_NUMBERS);
            }
        }
    }

    public static void validateRangeInputLottoBonusNumber(int bonusNumber) {
        if (!isValidNumberRange(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_RANGE_BONUS_NUMBER);
        }
    }

    public static void validateUniqueInputLottoBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_DUPLICATE_BONUS_NUMBER);
        }
    }

    static public boolean isValidNumberRange(int number) {
        return 1 <= number && number <= 45;
    }
}
