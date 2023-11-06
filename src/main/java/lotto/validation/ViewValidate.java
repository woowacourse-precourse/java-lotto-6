package lotto.validation;

import lotto.config.ErrorMessage;

public class ViewValidate {
    private ViewValidate() {
    }

    public static void validateNotSpaceOrEmpty(String content) {
        if (content.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.SPACE_OR_EMPTY.getMessage());
        }
    }

    public static void validateNotNull(String content) {
        if (content == null) {
            throw new NullPointerException(ErrorMessage.NULL.getMessage());
        }
    }

    public static void validateConvertingString2Int(String content) {
        if (!content.matches("\\d+")) {
            throw new NumberFormatException(ErrorMessage.STRING_IS_NOT_INT.getMessage());
        }
    }
}
