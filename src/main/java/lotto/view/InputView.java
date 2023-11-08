package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validator.InputValidator;

public class InputView {
    private static final String COMMA = ",";

    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public int getNumber() {
        String inputNumber = Console.readLine();
        inputValidator.validateNumber(inputNumber);
        return Integer.parseInt(inputNumber);
    }

    public List<Integer> getNumbers() {
        List<String> inputNumbers = Arrays.asList(Console.readLine().split(COMMA));
        for (int i = 0; i < inputNumbers.size(); i++) {
            inputValidator.validateNumber(inputNumbers.get(i));
        }

        return inputNumbers.stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
