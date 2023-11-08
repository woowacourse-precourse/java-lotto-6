package lotto.global.util;

import java.util.regex.Pattern;
import lotto.global.constant.message.ErrorMessage;
import lotto.global.exception.LottoIllegalArgumentException;

public class Validator {
    private final static Pattern INT_FORMAT = Pattern.compile("\\d+");


    public static void validateIntFormat(String value) {
        if (!INT_FORMAT.matcher(value).matches()) {
            throw new LottoIllegalArgumentException(ErrorMessage.INT_FORMAT_ERROR);
        }
    }

    public static void validateIntFormat(String[] values) {
        for (String value : values) {
            validateIntFormat(value);
        }
    }
}
