package lotto.exception;

import static lotto.constants.LottoConstants.LOTTO_DIVISION;
import static lotto.constants.LottoConstants.LOTTO_NOT_DIVISION;
import static lotto.constants.LottoConstants.LOTTO_NUMBER_OVER_MAX;
import static lotto.constants.LottoConstants.LOTTO_SIZE_MAX_LENGTH;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static void validateCheckPrice(int price) {
        if (price % LOTTO_DIVISION != LOTTO_NOT_DIVISION) {
            throw new NumberFormatException(ErrorMsg.ERROR_LOTTO_PRICE_DIVISON.getMsg());
        }
    }

    public static void validateBonusNumberCheck(List<Integer> lottoNumbers, int commonInput) {
        if (lottoNumbers.contains(commonInput)) {
            throw new UserInputException(ErrorMsg.ERROR_LOTTO_DUPLICATES_NUMBERS.getMsg());
        }
    }

    public static void validateDuplicateWinningNumber(int originLength, int afterLength) {
        if (originLength != afterLength) {
            throw new UserInputException(ErrorMsg.ERROR_LOTTO_DUPLICATES_NUMBERS.getMsg());
        }
    }

    public static void validateWinningNumberLength(int lottoNumberLength) {
        if (lottoNumberLength != LOTTO_SIZE_MAX_LENGTH) {
            throw new UserInputException(ErrorMsg.ERROR_LOTTO_NUMBERS_SIZE_MAX.getMsg());
        }
    }

    public static void validateLottoSizeCheck(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE_MAX_LENGTH) {
            throw new UserInputException(ErrorMsg.ERROR_LOTTO_NUMBERS_SIZE_MAX.getMsg());
        }
    }

    public static void validateLottoDuplicate(List<Integer> numbers) {
        Set<Integer> duplicates = new HashSet<>(numbers);
        if (duplicates.size() != LOTTO_SIZE_MAX_LENGTH) {
            throw new UserInputException(ErrorMsg.ERROR_LOTTO_DUPLICATES_NUMBERS.getMsg());
        }
    }

    public static boolean isInvalidLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number > LOTTO_NUMBER_OVER_MAX);
    }

    public static void validateLottoNumberOverMax(List<Integer> numbers) {
        if (isInvalidLottoNumber(numbers)) {
            throw new UserInputException(ErrorMsg.ERROR_LOTTO_NUMBER_OVER_MAX.getMsg());
        }
    }
}
