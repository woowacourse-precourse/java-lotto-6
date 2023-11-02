package lotto.validator;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstants;
import lotto.model.Lotto;
import lotto.utils.Parser;

public class Validator {
    public static void validateBudgetInput(String userInput) {
        validateInteger(userInput);
        int number = Integer.parseInt(userInput);
        validatePositiveInteger(number);
        validateDividedBy1000(number);
    }

    public static void validateLottoTicketInput(String userInput) {
        List<String> parsedNumbers = Parser.parseWithComma(userInput);
        parsedNumbers.forEach(Validator::validateInteger);

        List<Integer> numbers = new ArrayList<>();
        parsedNumbers.forEach(number -> numbers.add(Integer.parseInt(number)));
        validateNumbers(numbers);
    }

    public static void validateNumbers(List<Integer> numbers) {
        validateLottoTicketSize(numbers.size());
        numbers.forEach(Validator::validateNumberInRange);
        validateDuplication(numbers);
    }

    public static void validateBonusNumberInput(Lotto winningLottoTicket, String userInput) {
        validateInteger(userInput);
        int bonusNumber = Integer.parseInt(userInput);
        validateNumberInRange(bonusNumber);
        validateDuplication(winningLottoTicket, bonusNumber);
    }

    public static void validateInteger(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_MESSAGE.getMessage());
        }
    }

    public static void validatePositiveInteger(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NON_POSITIVE_INTEGER_MESSAGE.getMessage());
        }
    }

    public static void validateDividedBy1000(int number) {
        if (number % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVIDED_BY_1000_MESSAGE.getMessage());
        }
    }

    public static void validateLottoTicketSize(int size) {
        if (size != LottoConstants.LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.THE_SIZE_OF_LOTTO_IS_NOT_PROPER_MESSAGE.getMessage());
        }
    }

    public static void validateNumberInRange(int number) {
        if (number < LottoConstants.LOTTO_NUMBER_MIN || number > LottoConstants.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_NOT_IN_RANGE_MESSAGE.getMessage());
        }
    }

    public static void validateDuplication(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_MESSAGE.getMessage());
        }
    }

    private static void validateDuplication(Lotto winningLottoTicket, int bonusNumber) {
        if (winningLottoTicket.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_MESSAGE.getMessage());
        }
    }
}
