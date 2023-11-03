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
    private int bonusNumber;
    private List<Integer> winningNumbers;

    public List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                List<String> inputValues = Arrays.asList(inputService.inputValue().split(","));
                List<Integer> winningNumbers = getWinningNumbers(inputValues);
                validateService.validateInputWinningNumbersAll(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private List<Integer> getWinningNumbers(List<String> inputValues) {
        winningNumbers = new ArrayList<>();
        for (String value : inputValues) {
            try {
                int number = Integer.parseInt(value.trim());
                winningNumbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER_ERROR.getMessage());
            }
        }
        return winningNumbers;
    }

    public int inputBonusNumber() {
        while (true) {
            try {
                bonusNumber = validateService.validateNumber(inputService.inputValue());
                validateService.validateBonusNumber(bonusNumber,winningNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
