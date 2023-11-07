package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputConverter {
    private static final String DELIMITER = ",";

    public static int convertStringToInt(String input) {
        InputValidator.validateInput(input);

        return Integer.valueOf(input);
    }

    public static List<Integer> convertToList(String input) {
        try {
            validateNotSurroundedByDelimiters(input);
            return Arrays.stream(input.trim().split(DELIMITER))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자만 가능합니다.");
        }
    }

    private static void validateNotSurroundedByDelimiters(String input) {
        int firstIndex = 0;
        int lastIndex = input.length() - 1;
        char firstChar = input.charAt(firstIndex);
        char lastChar = input.charAt(lastIndex);

        if (isDelimiter(firstChar) || isDelimiter(lastChar)) {
            throw new IllegalArgumentException("[ERROR] 옳지 않은 형식의 당첨 번호 입력입니다. 올바른 형식으로 다시 입력해주세요.");
        }
    }

    private static boolean isDelimiter(char ch) {
        return String.valueOf(ch).equals(DELIMITER);
    }
}
