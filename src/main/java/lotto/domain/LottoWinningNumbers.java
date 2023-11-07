package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoNumber;
import lotto.service.InputService;
import lotto.service.MessageService;

public class LottoWinningNumbers {
    private final InputService inputService = new InputService();
    private final MessageService messageService = new MessageService();
    private List<Integer> winningNumber;

    public LottoWinningNumbers getWinningNumbersInfo() {
        this.winningNumber = inputWinningNumbers();
        return this;
    }

    public List<Integer> inputWinningNumbers() {
        messageService.inputWinningNumberMessage();
        while (true) {
            try {
                List<String> inputValues = Arrays.asList(inputService.inputValue().split(","));
                List<Integer> winningNumbers = separateNumbers(inputValues);
                validateInputWinningNumbersAll(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> separateNumbers(List<String> inputValues) {
        winningNumber = new ArrayList<>();
        for (String value : inputValues) {
            try {
                int number = Integer.parseInt(value.trim());
                winningNumber.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER_ERROR.getMessage());
            }
        }
        return winningNumber;
    }


    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    private void validateInputWinningNumbersAll(List<Integer> winningNumbers) {
        validateInputLottoRange(winningNumbers);
        validateDuplicateWinningNumber(winningNumbers);
        validateWinningNumbersCount(winningNumbers);
    }

    private void validateInputLottoRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LottoNumber.START_NUMBER.getNumber() || number > LottoNumber.END_NUMBER.getNumber()) {
                throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER_OVER_RANGE_ERROR.getMessage());
            }
        }
    }

    private void validateDuplicateWinningNumber(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_DUPLICATE_NUMBER_ERROR.getMessage());
        }
    }

    private void validateWinningNumbersCount(List<Integer> numbers) {
        if (numbers.size() != LottoNumber.LOTTO_COUNT.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_INCORRECT_NUMBER_COUNT_ERROR.getMessage());
        }
    }
}
