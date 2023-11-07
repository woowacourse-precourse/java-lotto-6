package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public List<Integer> inputNumbers(String inputMessage) {
        System.out.println(inputMessage);
        String string = Console.readLine();
        return parseNumbers(string);
    }

    public int inputNumber(String inputMessage) {
        System.out.println(inputMessage);
        String string = Console.readLine();
        return parseNumber(string);
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
