package lotto.controller.validator;

import static lotto.model.LottoGenerator.LOTTO_TICKET_PRICE;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoConstants;
import lotto.utils.Parser;

public class InputValidator {
    // 구입 금액 입력 검증
    public void validateBudgetInput(String userInput) {
        validateInteger(userInput);
        int number = Integer.parseInt(userInput);
        validatePositiveInteger(number);
        validateDividedByLottoTicketPrice(number);
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
    public void validateBonusNumberInput(String userInput) {
        validateInteger(userInput);
        int bonusNumber = Integer.parseInt(userInput);
        validateNumberInRange(bonusNumber);
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
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_INTEGER.getMessage());
        }
    }

    public void validateDividedByLottoTicketPrice(int number) {
        if (number % LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVIDED_BY_LOTTO_TICKET_PRICE.getMessage());
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