package lotto.util;

import static lotto.enums.Delimiter.COMMA;
import static lotto.enums.ErrorMassage.INVALID_NUMBER;
import static lotto.enums.ErrorMassage.NOT_SEPARATE_BY_DELIMITER;
import static lotto.enums.LottoConfig.LOTTO_COUNT;

import java.util.Arrays;
import java.util.List;

public class StringUtil {
    public static int convertToInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER.getMassage());
        }
    }

    public static List<Integer> convertToIntListByDelimiter(final String input) {
        String[] inputs = input.split(COMMA.getValue());
        if (inputs.length != LOTTO_COUNT.getValue()) {
            throw new IllegalArgumentException(NOT_SEPARATE_BY_DELIMITER.getMassage());
        }

        return Arrays.stream(inputs)
                .map(StringUtil::convertToInt)
                .toList();
    }
}
