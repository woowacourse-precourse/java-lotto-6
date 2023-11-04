package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class NumberScanner {
    public static final String ERROR_NOT_A_NUMBER = "제대로 된 숫자형식이 아닙니다.";

    public int scanSingleInteger() {
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_A_NUMBER);
        }
    }

    public List<Integer> scanCommaSeperatedIntegers() {
        String input = Console.readLine();
        String[] seperated = input.split(",");
        try {
            return Arrays.stream(seperated)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_A_NUMBER);
        }

    }

    public void close() {
        Console.close();
    }
}
