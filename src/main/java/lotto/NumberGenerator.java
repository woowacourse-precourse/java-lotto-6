package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

public class NumberGenerator {
    public static List<Integer> formatNumbers(String input) {
        String[] numbers = input.split(",", -1);
        List<Integer> result = new ArrayList<>();

        for (String number : numbers) {
            result.add(formatNumber(number));
        }
        return result;
    }

    public static Integer formatNumber(String input) {
        validate(input);
        return Integer.valueOf(input);
    }


    private static void validate(String input) {
        if (input == null) {
            throw new IllegalArgumentException("[ERROR] 반드시 입력 값이 있어야 합니다.");
        }
        if (!Pattern.matches("^[0-9]*$", input)) {
            System.out.println("[ERROR] 입력은 숫자만 가능합니다.");
            throw new NoSuchElementException("[ERROR] 입력은 숫자만 가능합니다.");
        }
    }
}
