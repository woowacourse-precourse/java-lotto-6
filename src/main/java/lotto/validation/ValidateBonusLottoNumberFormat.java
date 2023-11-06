package lotto.validation;

import lotto.exception.InvalidDuplicatedNumberException;
import lotto.exception.InvalidLottoNumberException;

import java.util.Arrays;

public class ValidateBonusLottoNumberFormat {
    public static void validate(String inputValue, String[] existingNumbers) {
        checkNumberFormat(inputValue);
        checkDuplicatedNumber(inputValue, existingNumbers);
    }

    private static void checkNumberFormat(String value) {
        if (!value.matches("^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|4{1}[0-5]{1}$")) {
            throw new InvalidLottoNumberException();
        }
    }

    private static void checkDuplicatedNumber(String value, String[] existingNumbers) {
        Arrays.stream(existingNumbers)
                .forEach(e -> {
                    if (e.equals(value)) {
                        throw new InvalidDuplicatedNumberException();
                    }
                });
    }
}
