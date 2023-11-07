package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.constant.Constant;
import lotto.utils.message.ErrorMessage;

public class StringUtils {
    public static int convertToInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER);
        }
    }

    public static List<Integer> split(String s) {
        try {
            return Arrays.asList(s.split(Constant.SPLIT_DELIMITER)).stream()
                .map(n -> convertToInt(n))
                .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_SPLIT_DELIMITER);
        }
    }
}
