package lotto.function;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public static int toInteger(String number) {
        validateInteger(number);
        return Integer.parseInt(number.trim());
    }

    public static List<Integer> toIntegerList(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(Parser::toInteger)
                .toList();
    }

    private static void validateInteger(String number) {
        try {
            Integer.parseInt(number.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해 주세요.");
        }
    }
}
