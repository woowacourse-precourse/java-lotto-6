package lotto.common;

import static lotto.message.ErrorMessage.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputUtils {

    private InputUtils() {
    }

    public static List<Integer> getNumbers() {
        try {
            String numbers = Console.readLine();
            return Arrays.stream(numbers.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INPUT_INT);
        }
    }

    public static int getNumber() {
        try {
            String number = Console.readLine();
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INPUT_INT);
        }
    }
}
