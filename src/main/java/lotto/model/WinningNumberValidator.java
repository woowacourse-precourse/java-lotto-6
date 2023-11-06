package lotto.model;

import static lotto.utils.Constants.*;

import java.util.Arrays;
import java.util.List;

public class WinningNumberValidator {
    String winningNumber;
    List<String> numbers;

    public WinningNumberValidator(String winningNumber) {
        this.winningNumber = winningNumber;
        this.numbers = Arrays.asList(winningNumber.split(","));
        validate();
    }

    private void validate() {
        isNumber();
        isDuplicate();
    }

    private void isNumber() {
        numbers.stream()
                .filter(numbers -> !WINNING_NUMBER_PATTERN.matcher(numbers).find())
                .findAny()
                .ifPresent(s -> {
                        throw new IllegalArgumentException(ERROR_MESSAGE + WINNING_NUMBER_ERROR);
                });
    }

    private void isDuplicate(){
        if(numbers.stream().distinct().count() < numbers.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + WINNING_NUMBER_DUPLICATE_ERROR);
        }
    }

}
