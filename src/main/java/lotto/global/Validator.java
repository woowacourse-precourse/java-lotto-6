package lotto.global;

import static lotto.global.RegularExpression.LOTTO_NUMBER_PATTERN;
import static lotto.global.RegularExpression.PURCHASE_PRICE_PATTERN;
import static lotto.global.common.GameMessage.BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE;
import static lotto.global.common.GameMessage.LOTTO_NUMBERS_COUNT_ERROR_MESSAGE;
import static lotto.global.common.GameMessage.LOTTO_NUMBERS_DUPLICATE_ERROR_MESSAGE;
import static lotto.global.common.GameMessage.LOTTO_NUMBER_FORMAT_ERROR_MESSAGE;
import static lotto.global.common.GameMessage.PURCHASE_PRICE_ERROR_MESSAGE;
import static lotto.global.common.LottoConstant.PICK_NUMBERS_COUNT;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static boolean purchasePriceFormat(String input) {
        if (!input.matches(PURCHASE_PRICE_PATTERN)) {
            throw new IllegalArgumentException(PURCHASE_PRICE_ERROR_MESSAGE.message);
        }

        return true;
    }

    public static boolean lottoNumbersWithString(List<String> lottoNumbers) {
        lottoNumbersCountWithString(lottoNumbers);
        lottoNumbersFormatWithString(lottoNumbers);
        lottoNumbersDuplicateWithString(lottoNumbers);

        return true;
    }

    public static void lottoNumbersWithInteger(List<Integer> lottoNumbers) {
        lottoNumbersCountWithInteger(lottoNumbers);
        lottoNumbersFormatWithInteger(lottoNumbers);
        lottoNumbersDuplicateWithInteger(lottoNumbers);
    }

    public static boolean bonusNumber(String input, List<String> winningNumbers) {
        lottoNumberFormat(input);
        bonusNumberDuplicate(input, winningNumbers);

        return true;
    }

    private static void lottoNumbersCountWithString(List<String> numbers) {
        if (numbers.size() != PICK_NUMBERS_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_COUNT_ERROR_MESSAGE.message);
        }
    }

    private static void lottoNumbersFormatWithString(List<String> numbers) {
        for (String number : numbers) {
            lottoNumberFormat(number);
        }
    }

    private static void lottoNumbersDuplicateWithString(List<String> numbers) {
        Set<String> noDuplicateNumbers = new HashSet<>(numbers);

        if (noDuplicateNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATE_ERROR_MESSAGE.message);
        }
    }

    private static void lottoNumbersCountWithInteger(List<Integer> numbers) {
        if (numbers.size() != PICK_NUMBERS_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_COUNT_ERROR_MESSAGE.message);
        }
    }

    private static void lottoNumbersFormatWithInteger(List<Integer> numbers) {
        for (Integer number : numbers) {
            lottoNumberFormat(String.valueOf(number));
        }
    }

    private static void lottoNumbersDuplicateWithInteger(List<Integer> numbers) {
        Set<Integer> noDuplicateNumbers = new HashSet<>(numbers);

        if (noDuplicateNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATE_ERROR_MESSAGE.message);
        }
    }

    private static void lottoNumberFormat(String input) {
        if (!input.matches(LOTTO_NUMBER_PATTERN)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_FORMAT_ERROR_MESSAGE.message);
        }
    }

    private static void bonusNumberDuplicate(String input, List<String> winningNumbers) {
        for (String number : winningNumbers) {
            if (input.equals(number)) {
                throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE.message);
            }
        }
    }
}
