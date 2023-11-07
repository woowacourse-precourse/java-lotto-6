package lotto.utils.validator;

import static lotto.utils.constants.LottoConstants.INPUT_FORMAT;
import static lotto.utils.constants.LottoConstants.LOTTO_NUMBER_LENGTH;
import static lotto.utils.constants.LottoConstants.LOTTO_TICKET_PRICE;
import static lotto.utils.constants.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.utils.constants.LottoConstants.MIN_LOTTO_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class Validator {

    public static void validateEmpty(String inputNumber) {
        if (inputNumber == null || inputNumber.isBlank()) {
            throw LottoException.from(ErrorMessage.EMPTY);
        }
    }

    public static void validateEmpty(List<Integer> inputNumbers) {
        if (inputNumbers == null || inputNumbers.isEmpty()) {
            throw LottoException.from(ErrorMessage.EMPTY);
        }
    }

    public static void validateLength(List<Integer> inputNumbers) {
        if (inputNumbers.size() != LOTTO_NUMBER_LENGTH) {
            throw LottoException.from(ErrorMessage.INVALID_NUMBER_LENGTH);
        }
    }

    public static void validateUniqueValue(List<Integer> inputNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(inputNumbers);
        if (uniqueNumbers.size() != inputNumbers.size()) {
            throw LottoException.from(ErrorMessage.DUPLICATED);
        }
    }

    public static void validateUniqueValue(List<Integer> inputNumbers, int number) {
        if (inputNumbers.contains(number)) {
            throw LottoException.from(ErrorMessage.DUPLICATED);
        }
    }

    public static void validateNumberRange(int number) {
        if (isOutOfNumberRange(number)) {
            throw LottoException.from(ErrorMessage.INVALID_NUMBER_RANGE);
        }
    }

    public static void validateNumberRange(List<Integer> inputNumbers) {
        if (inputNumbers.stream().anyMatch(Validator::isOutOfNumberRange)){
            throw LottoException.from(ErrorMessage.INVALID_NUMBER_RANGE);
        }
    }

    public static void validateNumber(String inputNumber) {
        if (!isNumber(inputNumber)) {
            throw LottoException.from(ErrorMessage.INVALID_INPUT);
        }
    }

    public static void validateFormat(String inputNumber) {
        if (!isValidFormat(inputNumber)) {
            throw LottoException.from(ErrorMessage.INVALID_INPUT_FORMAT);
        }
    }

    public static void validatePrice(int inputPrice) {
        if (isInvalidPrice(inputPrice)) {
            throw LottoException.from(ErrorMessage.INVALID_INPUT_PRICE);
        }
    }

    private static boolean isOutOfNumberRange(int number) {
        return number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER;
    }

    private static boolean isInvalidPrice(int inputPrice) {
        return inputPrice % LOTTO_TICKET_PRICE != 0;
    }

    private static boolean isNumber(String inputNumber) {
        return inputNumber.chars().allMatch(Character::isDigit);
    }

    private static boolean isValidFormat(String inputNumber) {
        return Pattern.matches(INPUT_FORMAT, inputNumber);
    }
}
