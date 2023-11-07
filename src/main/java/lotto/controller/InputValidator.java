package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoConstants;
import lotto.utils.Parser;

public class InputValidator {
    public static final String ERROR_MESSAGE_HEADER = "[ERROR]";
    public static final String WHITE_SPACE = " ";
    public static final String NOT_INTEGER = "정수가 아닙니다.";
    public static final String NOT_POSITIVE_INTEGER = "양의 정수가 아닙니다.";
    public static final String NOT_DIVIDED_BY_LOTTO_TICKET_PRICE = "로또 티켓 금액의 배수가 아닙니다.";
    public static final String NOT_PROPER_SIZE_OF_LOTTO = "번호의 개수가 6개가 아닙니다.";
    public static final String NUMBER_NOT_IN_RANGE = "올바른 범위의 수가 아닙니다.";
    public static final String HAS_DUPLICATED_NUMBER = "중복 값이 존재합니다.";
    public static final int LOTTO_TICKET_PRICE = 1000;


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
            throw new IllegalArgumentException(createErrorMessage(NOT_INTEGER));
        }
    }

    public void validatePositiveInteger(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(createErrorMessage(NOT_POSITIVE_INTEGER));
        }
    }

    public void validateDividedByLottoTicketPrice(int number) {
        if (number % LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException(createErrorMessage(NOT_DIVIDED_BY_LOTTO_TICKET_PRICE));
        }
    }

    public void validateNumbers(List<Integer> numbers) {
        validateLottoTicketSize(numbers.size());
        numbers.forEach(this::validateNumberInRange);
        validateDuplication(numbers);
    }

    public void validateLottoTicketSize(int size) {
        if (size != LottoConstants.SIZE_OF_LOTTO) {
            throw new IllegalArgumentException(createErrorMessage(NOT_PROPER_SIZE_OF_LOTTO));
        }
    }

    public void validateNumberInRange(int number) {
        if (number < LottoConstants.LOTTO_NUMBER_MIN || number > LottoConstants.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(createErrorMessage(NUMBER_NOT_IN_RANGE));
        }
    }

    public void validateDuplication(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(createErrorMessage(HAS_DUPLICATED_NUMBER));
        }
    }

    public String createErrorMessage(String message) {
        return ERROR_MESSAGE_HEADER
                + WHITE_SPACE
                + message;
    }
}