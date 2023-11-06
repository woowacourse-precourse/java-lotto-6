package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;
import lotto.validation.LottoNumberValidator;

public class WinningNumbersGenerator {
    public static Lotto generateWinningNumbers() {
        while (true) {
            String inputWithComma = InputHandler.askWinningNumbers();

            List<String> input = (Arrays.asList(inputWithComma.split(",")));
            if (validate(input)) {
                return new Lotto(convertToIntegers(input));
            }
        }
    }

    public static boolean validate(List<String> input) {
        LottoNumberValidator validator = new LottoNumberValidator();
        try {
            for (String str : input) {
                validator.validate(str);
            }
            List<Integer> numbers = convertToIntegers(input);
            new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            handleError(e.getMessage());
            return false;
        }
        return true;
    }

    private static List<Integer> convertToIntegers(List<String> input) {
        return input.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void handleError(String message) {
        OutputHandler.printErrorMessage(message);
    }
}
