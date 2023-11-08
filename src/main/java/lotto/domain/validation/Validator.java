package lotto.domain.validation;

import static lotto.domain.util.Constant.LOTTO_COUNT;
import static lotto.domain.util.Constant.LOTTO_PRICE;
import static lotto.domain.util.Constant.MAX_LOTTO_NUMBER;
import static lotto.domain.util.Constant.MIN_LOTTO_NUMBER;
import static lotto.exception.ErrorMessage.LOTTO_MONEY_INPUT_ERROR;
import static lotto.exception.ErrorMessage.LOTTO_MONEY_INPUT_SMALL_ERROR;
import static lotto.exception.ErrorMessage.LOTTO_NUMBER_COUNT_ERROR;
import static lotto.exception.ErrorMessage.LOTTO_NUMBER_DUPLICATED_ERROR;
import static lotto.exception.ErrorMessage.LOTTO_NUMBER_FORMAT_ERROR;
import static lotto.exception.ErrorMessage.LOTTO_NUMBER_RANGE_ERROR;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
import lotto.exception.LottoException;

public class Validator {
    private static final String LOTTO_NUMBER_REGEX = "^(\\d+,)+\\d+$";
    public static final String NUMBER_DIVIDER = ",";

    private Validator() {
    }

    public static void validateMoney(int parsedMoney) {
        if (parsedMoney < LOTTO_PRICE) {
            throw new LottoException(LOTTO_MONEY_INPUT_SMALL_ERROR);
        }
        if (parsedMoney % LOTTO_PRICE != 0) {
            throw new LottoException(LOTTO_MONEY_INPUT_ERROR);
        }
    }

    public static void validateLottoNumbers(String numbersInput) {
        if (!Pattern.matches(LOTTO_NUMBER_REGEX, numbersInput)) {
            throw new LottoException(LOTTO_NUMBER_FORMAT_ERROR);
        }
        List<Integer> numbers = numbersStringToList(numbersInput);
        validateLottoNumbersList(numbers);
    }

    public static void validateBonusNumber(String bonusNumberInput) {
        if (!isOverRangedNumber(Integer.parseInt(bonusNumberInput))) {
            throw new LottoException(LOTTO_NUMBER_RANGE_ERROR);
        }
    }

    public static void validateLottoNumbersList(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new LottoException(LOTTO_NUMBER_COUNT_ERROR);
        }
        if (hasDuplicatedNumber(numbers)) {
            throw new LottoException(LOTTO_NUMBER_DUPLICATED_ERROR);
        }
        if (hasOverRangedNumber(numbers)) {
            throw new LottoException(LOTTO_NUMBER_RANGE_ERROR);
        }
    }

    private static boolean hasDuplicatedNumber(List<Integer> numbers) {
        return new HashSet<>(numbers).size() != numbers.size();
    }

    private static boolean hasOverRangedNumber(List<Integer> numbers) {
        return !numbers.stream()
                .allMatch(Validator::isOverRangedNumber);
    }

    public static List<Integer> numbersStringToList(String numbers) {
        return Arrays.stream(numbers.split(NUMBER_DIVIDER))
                .map(Integer::parseInt)
                .toList();
    }

    private static boolean isOverRangedNumber(int number) {
        return (number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER);
    }
}
