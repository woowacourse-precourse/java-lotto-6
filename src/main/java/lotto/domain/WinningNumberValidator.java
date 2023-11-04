package lotto.domain;

import static lotto.constant.LottoNumber.WINNING_NUMBER_LENGTH;
import static lotto.constant.message.ErrorMessage.INVALID_LENGTH_WINNING_NUMBER;
import static lotto.constant.message.ErrorMessage.INVALID_RANGE_WINNING_NUMBER;
import static lotto.constant.message.ErrorMessage.NON_INTEGER_WINNING_NUMBER;

import java.util.HashSet;
import java.util.List;

public class WinningNumberValidator {

    private void checkValidInteger(List<String> numbers) {
        for (String number : numbers) {
            try {
                Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(NON_INTEGER_WINNING_NUMBER.getMessage());
            }
        }
    }

    private void checkNumbersLength(List<String> numbers) {
        if (numbers.size() != WINNING_NUMBER_LENGTH.getNumber()) {
            throw new IllegalArgumentException(INVALID_LENGTH_WINNING_NUMBER.getMessage());
        }
    }

    private void checkNumbersRange(List<String> numbers) {
        if (numbers.stream()
                .anyMatch(number -> Integer.parseInt(number) < 1 || Integer.parseInt(number) > 45)) {
            throw new IllegalArgumentException(INVALID_RANGE_WINNING_NUMBER.getMessage());
        }
    }

    private void checkNumbersDuplicate(List<String> numbers) {
        HashSet<String> uniqueNumbers = new HashSet<>();

        if (numbers.stream().anyMatch(name -> !uniqueNumbers.add(name))) {
            throw new IllegalArgumentException();
        }
    }
}
