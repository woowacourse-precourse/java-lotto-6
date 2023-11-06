package lotto.validation;

import lotto.config.ErrorMessage;
import lotto.util.CustomStringUtil;

public class ViewValidate {
    private ViewValidate() {
    }

    public static void validateNotSpaceOrEmpty(String content) {
        if (CustomStringUtil.isSpaceOrNull(content)) {
            throw new IllegalArgumentException(ErrorMessage.SPACE_OR_EMPTY.getMessage());
        }
    }

    public static void validateNotNull(String content) {
        if (CustomStringUtil.isNull(content)) {
            throw new NullPointerException(ErrorMessage.NULL.getMessage());
        }
    }

    public static void validateConvertingString2Int(String contetnt) {
        if (!CustomStringUtil.canConvertString2Int(contetnt)) {
            throw new NumberFormatException(ErrorMessage.STRING_IS_NOT_INT.getMessage());
        }
    }
}
