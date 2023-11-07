package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputDataException {
    public static void validatePaymentInput(String payment) {
        if(!payment.matches("\\d+")) {
            throw new IllegalArgumentException(IllegalArgumentMessage.ERROR_PAYMENT_INPUT);
        }
    }

    public static void validateWinningLottoNumbersInput(String numbersInput) {
        if(!numbersInput.contains(",")) {
            throw new IllegalArgumentException(IllegalArgumentMessage.ERROR_SPLIT_IDENTIFICATION);
        }

        List<String> numbers = Arrays.stream(numbersInput.split(",")).collect(Collectors.toList());
        if(numbers.size() != LottoConstant.PICK_COUNT) {
            throw new IllegalArgumentException(IllegalArgumentMessage.ERROR_PICK_COUNT);
        }
        for(String number : numbers) {
            if(!number.matches("\\d+")) {
                throw new IllegalArgumentException(IllegalArgumentMessage.ERROR_ONLY_NUMBERS);
            }
        }
    }
}
