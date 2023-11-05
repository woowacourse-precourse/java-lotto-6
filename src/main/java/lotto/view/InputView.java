package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.system.SystemMessage;
import lotto.validator.InputValidator;

public class InputView {
    public static long readLong() {
        String userInput = Console.readLine();
        InputValidator.validate(userInput);
        System.out.println();
        return Long.parseLong(userInput);
    }

    public static List<Integer> readIntegerList() {
        Stream<String> userInput = Arrays.stream(
                Console.readLine().split(SystemMessage.WINNING_NUMBER_SEPARATOR.getMessage()));
        userInput.forEach(InputValidator::validate);
        System.out.println();
        return userInput
                .map(Integer::valueOf)
                .toList();
    }

    public static int readInt() {
        String userInput = Console.readLine();
        InputValidator.validate(userInput);
        System.out.println();
        return Integer.parseInt(userInput);
    }
}
