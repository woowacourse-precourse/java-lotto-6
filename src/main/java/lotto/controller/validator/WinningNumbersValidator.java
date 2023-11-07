package lotto.controller.validator;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoConstants;
import lotto.utils.Parser;

public class WinningNumbersValidator implements InputValidator {
    private static WinningNumbersValidator winningNumbersValidator;

    private WinningNumbersValidator() {
    }

    public static WinningNumbersValidator getInstance() {
        if (winningNumbersValidator == null) {
            winningNumbersValidator = new WinningNumbersValidator();
            return winningNumbersValidator;
        }
        return winningNumbersValidator;
    }

    @Override
    public void validate(String userInput) {
        List<String> parsedNumbers = Parser.parseWithComma(userInput);
        parsedNumbers.forEach(this::validateInteger);

        List<Integer> numbers = new ArrayList<>();
        parsedNumbers.forEach(number -> numbers.add(Integer.parseInt(number)));
        validateNumbers(numbers);
    }

    public void validateInteger(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER.getMessage());
        }
    }

    public void validateNumbers(List<Integer> numbers) {
        validateLottoTicketSize(numbers.size());
        numbers.forEach(this::validateNumberInRange);
        validateDuplication(numbers);
    }

    public void validateLottoTicketSize(int size) {
        if (size != LottoConstants.SIZE_OF_LOTTO) {
            throw new IllegalArgumentException(ErrorMessage.NOT_PROPER_SIZE_OF_LOTTO.getMessage());
        }
    }

    public void validateNumberInRange(int number) {
        if (number < LottoConstants.LOTTO_NUMBER_MIN || number > LottoConstants.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_NOT_IN_RANGE.getMessage());
        }
    }

    public void validateDuplication(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.HAS_DUPLICATED_NUMBER.getMessage());
        }
    }
}
