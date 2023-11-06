package lotto.validator;

import static lotto.constant.ErrorMessageConstant.LOTTO_NUMBER_INPUT_ERROR_MESSAGE;
import static lotto.constant.ErrorMessageConstant.LOTTO_NUMBER_SIZE_ERROR_MESSAGE;
import static lotto.constant.ErrorMessageConstant.LOTTO_PRICE_INPUT_ERROR_MESSAGE;
import static lotto.constant.SystemConstant.NUMBER_PATTERN;
import static lotto.constant.SystemConstant.PRICE_PATTERN;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputValidator {
    public static int validateLottoPriceInput(String input) {
        if (!Pattern.matches(PRICE_PATTERN, input)) {
            throw new IllegalArgumentException(LOTTO_PRICE_INPUT_ERROR_MESSAGE.getErrorMessage());
        }

        return Integer.parseInt(input);
    }

    public static List<Integer> validateLottoNumberInput(String input) {
        List<String> lottoNumbers = List.of(input.split(","));

        validateInputNumberCount(lottoNumbers);

        return lottoNumbers.stream()
                .map(InputValidator::validateNumber)
                .sorted()
                .collect(Collectors.toList());
    }

    private static void validateInputNumberCount(List<String> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_SIZE_ERROR_MESSAGE.getErrorMessage());
        }
    }

    public static int validateBonusNumberInput(String input) {
        return validateNumber(input);
    }

    private static int validateNumber(String input) {
        if (!Pattern.matches(NUMBER_PATTERN, input)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_INPUT_ERROR_MESSAGE.getErrorMessage());
        }

        return Integer.parseInt(input);
    }
}
