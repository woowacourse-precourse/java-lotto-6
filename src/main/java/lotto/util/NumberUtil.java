package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberUtil {
    public static int toInt(String value) {
        try {
            int number = Integer.parseInt(value);
            validatePositive(number);

            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private static void validatePositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("[ERROR] 숫자는 양수만 입력 가능합니다.");
        }
    }

    public static String[] split(String value) {
        return value.split(",");
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            numbers[i] = toInt(values[i].trim());
        }

        return numbers;
    }

    public static List<Integer> toListInteger(String[] values) {
        int[] numbers = toInts(values);

        return Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toList());
    }
}
