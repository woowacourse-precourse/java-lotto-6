package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public List<Integer> input(String inputMessage, boolean isNumbers) {
        System.out.println(inputMessage);
        String string = Console.readLine();
        if (isNumbers) {
            return parseNumbers(string);
        }
        int number = parseNumber(string);
        return Collections.singletonList(number);
    }

    private List<Integer> parseNumbers(String string) {
        return Arrays.stream(string.trim().split(","))
                .map(this::parseNumber)
                .collect(Collectors.toList());
    }

    private int parseNumber(String string) {
        try {
            return Integer.parseInt(string.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
