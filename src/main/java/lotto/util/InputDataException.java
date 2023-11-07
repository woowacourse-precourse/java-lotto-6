package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputDataException {
    public static void validatePaymentInput(String payment) {
        validateOnlyNumbers(payment, IllegalArgumentMessage.ERROR_PAYMENT_INPUT);
    }

    public static void validateWinningLottoNumbersInput(String numbersInput) {
        validateSplit(numbersInput, ",");

        List<String> numbers = Arrays.stream(numbersInput.split(","))
                .map(it -> it.trim())
                .collect(Collectors.toList());
        validateSize(numbers.size());
        for (String number : numbers) {
            validateOnlyNumbers(number, IllegalArgumentMessage.ERROR_ONLY_NUMBERS);
        }
    }

    public static void validateBonusNumberInput(String bonusNumberInput) {
        validateOnlyNumbers(bonusNumberInput, IllegalArgumentMessage.ERROR_ONLY_NUMBERS);
    }

    private static void validateOnlyNumbers(final String source, final String errorMesage) {
        if (!source.matches("\\d+")) {
            throw new IllegalArgumentException(errorMesage);
        }
    }

    private static void validateSplit(final String source, final String regex) {
        if (!source.contains(regex)) {
            throw new IllegalArgumentException(IllegalArgumentMessage.ERROR_SPLIT_IDENTIFICATION);
        }
    }

    private static void validateSize(final int numberCount) {
        if (numberCount != LottoConstant.PICK_COUNT) {
            throw new IllegalArgumentException(IllegalArgumentMessage.ERROR_PICK_COUNT);
        }
    }
}
