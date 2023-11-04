package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputManager {

    public static String receiveUserInput() {
        return removeInputSpace(Console.readLine());
    }

    private static String removeInputSpace(String input) {
        return input.replaceAll(" ", "");
    }

    public static List<Integer> winningLottoInput() {
        List<String> input = List.of(receiveUserInput().split(","));

        return input.stream()
                .map(number -> {
                    InputValidator.validateIsNumeric(number);
                    return Integer.parseInt(number);
                })
                .collect(Collectors.toList());
    }
}
