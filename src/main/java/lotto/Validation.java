package lotto;

import lotto.enums.ErrorMessage;

import java.util.List;

public class Validation {
    public static void validateNotNull(List<Integer> input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL_ERROR.getMessage());
        }
    }
}
