package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.MessageConstant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public InputView() {
    }

    public List<Integer> inputNumbers(String inputMessage) {
        System.out.println();
        System.out.println(inputMessage);
        String string = Console.readLine();
        return parseNumbers(string);
    }

    public int inputNumber(String inputMessage) {
        System.out.println();
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
            throw new IllegalArgumentException(MessageConstant.INPUT_NUMBER);
        }
    }
}
