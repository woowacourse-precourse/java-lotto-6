package lotto.input;

import java.util.Arrays;
import java.util.List;

import static lotto.configuration.ErrorMessage.*;
import static lotto.configuration.GameConfig.*;

public class InputProcessor {
    private final InputReader inputReader;

    public InputProcessor(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public Integer getUserPurchaseMoney() {
        String input = inputReader.read();
        validateIsInteger(input);
        return Integer.parseInt(input);
    }

    public List<Integer> getWinningNumbers() {
        String input = inputReader.read();
        validateWinningNumberInput(input);
        return parseWinningNumberInputToList(input);
    }

    public Integer getBonusNumber() {
        String input = inputReader.read();
        validateIsInteger(input);
        return Integer.valueOf(input);
    }

    private static void validateWinningNumberInput(String input) {
        String[] separatedInput = input.split(LOTTO_NUMBER_INPUT_SEPARATOR);
        Arrays.stream(separatedInput)
                .forEach(InputProcessor::validateIsInteger);
    }

    private static void validateIsInteger(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER);
        }
    }


    private List<Integer> parseWinningNumberInputToList(String input) {
        String[] separatedInput = input.split(LOTTO_NUMBER_INPUT_SEPARATOR);
        return Arrays.stream(separatedInput)
                .map(Integer::parseInt)
                .toList();
    }
}
