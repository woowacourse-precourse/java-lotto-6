package lotto.domain;

import java.util.List;

public class InputValidator {

    public static boolean isNotNumeric(String number) {
        return !number.matches("^[\\d]*$");
    }

    public static boolean isNotRemainderZero(String number, int divider) {
        return Integer.parseInt(number) % divider != 0;
    }

    public static boolean isNotMatchNumbersCount(String numbers, String delimiter, int count) {
        return numbers.split(delimiter).length != count;
    }

    public static boolean isDuplicateNumber(List<String> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    public static boolean isDuplicateNumber(List<Integer> numbers, int number) {
        return numbers.contains(number);
    }

    public static boolean isNumberNotInRange(String number, int start, int end) {
        return Integer.parseInt(number) < start || Integer.parseInt(number) > end;
    }
}
