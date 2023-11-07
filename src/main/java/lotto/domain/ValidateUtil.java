package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ValidateUtil {

    public static int toNumeric(String stringNumber) {
        try {
            return Integer.parseInt(stringNumber.strip());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> stringToArrayList(String inputNumbers) {
        List<Integer> numbers = Arrays.stream(inputNumbers.split(",")).map(ValidateUtil::toNumeric)
                .collect(Collectors.toList());
        return numbers;
    }

    public static void isInRange(int number, int startRange, int endRange) {
        if (number < startRange || number > endRange) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean isContain(int number, List<Integer> numbers) {
        return numbers.contains(number);
    }
}
