package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validator.InputValidator;

public class Input {

    public static Integer receiveOneNumber() {
        String input;
        while (true) {
            try {
                input = Console.readLine().trim();
                InputValidator.isNull(input);
                InputValidator.isInteger(input);
                break;
            } catch (IllegalArgumentException e) {
            }
        }
        return Integer.parseInt(input);
    }

    public static List<Integer> receiveNumbersSeparatedByCommas() {
        String[] inputs;
        while (true) {
            try {
                inputs = Console.readLine().trim().split(",");
                InputValidator.isNull(inputs);
                InputValidator.isInteger(inputs);
                break;
            } catch (IllegalArgumentException e) {
            }
        }
        return Arrays.stream(inputs).map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}