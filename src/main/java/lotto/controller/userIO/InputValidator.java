package lotto.controller.userIO;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstants;
import lotto.model.Lotto;
import lotto.utils.Parser;

public class InputValidator {
    // 구입 금액 입력 검증
    public void validateBudgetInput(String userInput) {
        validateInteger(userInput);
        int number = Integer.parseInt(userInput);
        validatePositiveInteger(number);
        validateDividedBy1000(number);
    }

    // 당첨 번호 입력 검증
    public void validateLottoTicketInput(String userInput) {
        List<String> parsedNumbers = Parser.parseWithComma(userInput);
        parsedNumbers.forEach(this::validateInteger);

        List<Integer> numbers = new ArrayList<>();
        parsedNumbers.forEach(number -> numbers.add(Integer.parseInt(number)));
        validateNumbers(numbers);
    }

    // 보너스 번호 입력 검증
    public void validateBonusNumberInput(Lotto winningLottoTicket, String userInput) {
        validateInteger(userInput);
        int bonusNumber = Integer.parseInt(userInput);
        validateNumberInRange(bonusNumber);
        validateDuplication(winningLottoTicket, bonusNumber);
    }

    public void validateInteger(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER.getMessage());
        }
    }

    public void validatePositiveInteger(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NON_POSITIVE_INTEGER.getMessage());
        }
    }

    public void validateDividedBy1000(int number) {
        if (number % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVIDED_BY_1000.getMessage());
        }
    }

    public void validateNumbers(List<Integer> numbers) {
        validateLottoTicketSize(numbers.size());
        numbers.forEach(this::validateNumberInRange);
        validateDuplication(numbers);
    }

    public void validateLottoTicketSize(int size) {
        if (size != LottoConstants.THE_SIZE_OF_ONE_LOTTO) {
            throw new IllegalArgumentException(ErrorMessage.THE_SIZE_OF_LOTTO_IS_NOT_PROPER.getMessage());
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

    public void validateDuplication(Lotto winningLottoTicket, int bonusNumber) {
        if (winningLottoTicket.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.HAS_DUPLICATED_NUMBER.getMessage());
        }
    }
}
