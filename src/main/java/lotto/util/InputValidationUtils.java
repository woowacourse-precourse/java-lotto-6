package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import static lotto.constants.ErrorMessage.*;

public class InputValidationUtils {

    public static void validateHasInput(String line) {
        if (line.isBlank()) {
            throw new IllegalArgumentException(CANNOT_READ_EMPTY_INPUT.getMessage());
        }
    }

    public static void validateIsIntFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    public static void validateDuplication(Lotto winningLotto, LottoNumber lottoNumber) {
        if (winningLotto.contains(lottoNumber)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER_EXIST.getMessage());
        }
    }
}
