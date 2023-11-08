package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Input {
    public static int getNaturalNumber() {
        String input = Console.readLine();
        Validation.validateNaturalNumber(input);
        return Integer.parseInt(input);
    }

    public static List<String> getSplitTokens(String regex) {
        String input = Console.readLine();
        return Arrays.stream(input.split(regex)).toList();
    }

    public static List<Integer> getSplitNaturalNumberList(String regex) {
        List<String> tokens = getSplitTokens(regex);
        Validation.validateNaturalNumber(tokens);
        return tokens.stream().map(Integer::parseInt).toList();
    }
}
