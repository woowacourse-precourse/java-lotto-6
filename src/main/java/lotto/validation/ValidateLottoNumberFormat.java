package lotto.validation;

import lotto.exception.InvalidBlankNumberException;
import lotto.exception.InvalidDuplicatedNumberException;
import lotto.exception.InvalidLottoNumberException;
import lotto.exception.InvalidLottoNumberSizeException;

import java.util.Arrays;

public class ValidateLottoNumberFormat {
    public static void validate(String inputValue) {
        String[] splited = inputValue.split(",");
        checkValidSize(splited);
        checkBlank(splited);
        checkNumberFormat(splited);
        checkDuplicatedNumber(splited);
    }

    private static void checkValidSize(String[] value) {
        if (value.length != 6) {
            throw new InvalidLottoNumberSizeException();
        }
    }

    private static void checkBlank(String[] value) {
        Arrays.stream(value)
                .forEach(v -> {
                    if (v.isBlank()) {
                        throw new InvalidBlankNumberException();
                    }
                });
    }

    private static void checkNumberFormat(String[] value) {
        Arrays.stream(value)
                .forEach(v -> {
                    if (!v.matches("^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|4{1}[0-5]{1}$")) {
                        throw new InvalidLottoNumberException();
                    }
                });
    }

    private static void checkDuplicatedNumber(String[] value) {
        if (value.length != Arrays.stream(value).distinct().count()) {
            throw new InvalidDuplicatedNumberException();
        }
    }
}
