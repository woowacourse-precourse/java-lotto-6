package lotto.validator;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstants;
import lotto.model.Lotto;
import lotto.utils.Parser;

public class InputValidator {
    public static void validateBudget(String userInput) {
        validateInteger(userInput);
        validatePositiveInteger(userInput);
        validateDividedBy1000(userInput);
    }

    private static void validateDividedBy1000(String userInput) {
        int number = Integer.parseInt(userInput);
        if (number % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVIDED_BY_1000_MESSAGE.getMessage());
        }
    }

    public static void validateLottoTicket(String userInput) {
        List<String> numbers = Parser.parseWithComma(userInput);
        validateLottoTicketSize(numbers.size());
        numbers.forEach(InputValidator::validateInteger);
        numbers.forEach(InputValidator::validateNumberInRange);
        validateDuplication(numbers);
    }

    private static void validateLottoTicketSize(int size) {
        if (size != LottoConstants.LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.THE_SIZE_OF_LOTTO_IS_DIFFERNT.getMessage());
        }
    }

    public static void validateBonusNumber(Lotto winningLottoTicket, String userInput) {
        validateInteger(userInput);
        validateNumberInRange(userInput);

        int bonusNumber = Integer.parseInt(userInput);
        validateDuplication(winningLottoTicket, bonusNumber);
    }

    private static void validateInteger(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_MESSAGE.getMessage());
        }
    }

    private static void validatePositiveInteger(String userInput) {
        int number = Integer.parseInt(userInput);
        if (number <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NON_POSITIVE_INTEGER_MESSAGE.getMessage());
        }
    }

    private static void validateNumberInRange(String userInput) {
        int number = Integer.parseInt(userInput);
        if (number < LottoConstants.LOTTO_NUMBER_MIN || number > LottoConstants.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_NOT_IN_RANGE_MESSAGE.getMessage());
        }
    }

    private static void validateDuplication(List<String> numbers) {
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
