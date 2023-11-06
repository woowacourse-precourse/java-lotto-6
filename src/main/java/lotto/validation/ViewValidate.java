package lotto.validation;

import lotto.config.ErrorMessage;
import lotto.util.StringUtil;

public class ViewValidate {
    private ViewValidate() {
    }

    public static void validateNotSpaceOrEmpty(String content) {
        if (StringUtil.isSpaceOrNull(content)) {
            throw new IllegalArgumentException(ErrorMessage.SPACE_OR_EMPTY.getMessage());
        }
    }

    public static void validateNotNull(String content) {
        if (StringUtil.isNull(content)) {
            throw new NullPointerException(ErrorMessage.NULL.getMessage());
        }
    }
}
