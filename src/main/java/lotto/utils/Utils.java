package lotto.utils;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.message.ErrorMessage;

import java.util.Arrays;
import java.util.stream.Stream;

public class Utils {
    public static int stringToInt(String str) {
        try {
            return Integer.parseInt(str.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_FORMAT_ERROR);
        }
    }

    public static int[] stringToIntArray(String str) {
        try {
            return Arrays.stream(str.split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_FORMAT_ERROR);
        }
    }
}
