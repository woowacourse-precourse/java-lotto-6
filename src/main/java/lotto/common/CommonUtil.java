package lotto.common;

import java.util.Arrays;
import java.util.List;

public class CommonUtil {

    public static final String COMMA = ",";

    public static long convertToLong(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바른 입력값이 아닙니다 숫자를 입력해주세요");
        }
    }

    public static List<Integer> convertToNumbers(String input) {
        return Arrays.stream(input.split(COMMA))
                .map(String::trim)
                .map(CommonUtil::convertToNumber)
                .toList();
    }

    public static int convertToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바른 입력값이 아닙니다 숫자를 입력해주세요");
        }
    }
}
