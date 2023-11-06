package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validator.InputValidator;

public class Input {

    public static Integer receiveOneNumber() {
        String input = Console.readLine().trim();
        InputValidator.isInteger(input);

        return Integer.parseInt(input);
    }

    public static List<Integer> receiveNumbersSeparatedByCommas() {
        String[] inputs = Console.readLine().trim().split(",");
        InputValidator.isInteger(inputs);

        return Arrays.stream(inputs).map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}