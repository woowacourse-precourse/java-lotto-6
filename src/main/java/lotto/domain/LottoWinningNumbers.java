package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.service.InputService;
import lotto.service.ValidateService;

public class LottoWinningNumbers {
    private final InputService inputService = new InputService();
    private final ValidateService validateService = new ValidateService();
    private List<Integer> winningNumbers;


    public List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                List<String> inputValues = Arrays.asList(inputService.inputValue().split(","));
                winningNumbers = getWinningNumbers(inputValues);
                validateService.validateInputWinningNumbersAll(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private List<Integer> getWinningNumbers(List<String> inputValues) {
        List<Integer> numbers = new ArrayList<>();
        for (String value : inputValues) {
            try {
                int number = Integer.parseInt(value.trim());
                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER_ERROR.getMessage());
            }
        }
        return numbers;
    }
}
