package lotto.dto;

import static lotto.validatior.InputWinningNumbersValidator.validateOnlyPositiveWinningNumbers;
import static lotto.validatior.InputWinningNumbersValidator.validateWinningNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputWinningNumbers {
    private final List<Integer> inputWinningNumbers;

    public InputWinningNumbers(String inputWinningNumbers) {
        validateOnlyPositiveWinningNumbers(inputWinningNumbers);
        List<Integer> inputNumbers = convertToList(inputWinningNumbers);
        validateWinningNumbers(inputNumbers);
        this.inputWinningNumbers = inputNumbers;
    }

    public List<Integer> getInputWinningNumbers() {
        return inputWinningNumbers;
    }

    private List<Integer> convertToList(String inputWinningNumbers) {
        return Arrays.stream(inputWinningNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
