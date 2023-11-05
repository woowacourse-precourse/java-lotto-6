package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.system.SystemMessage;
import lotto.validator.InputValidator;

public class InputView {
    public static long readLong() {
        String userInput = Console.readLine();
        InputValidator.validate(userInput);
        return Long.parseLong(userInput);
    }

    public static List<Integer> readIntegerList() {
        List<String> userInput = Arrays.stream(Console.readLine()
                .split(SystemMessage.WINNING_NUMBER_SEPARATOR.getMessage())).toList();
        userInput.forEach(InputValidator::validate);
        System.out.println();
        return userInput.stream()
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
