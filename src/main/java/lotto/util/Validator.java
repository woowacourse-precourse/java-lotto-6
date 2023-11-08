package lotto.util;

import static lotto.util.Constant.LOTTO_LENGTH;
import static lotto.util.Message.ErrorMessage.DUPLICATION_EXCEPTION;
import static lotto.util.Message.ErrorMessage.BUDGET_EXCEPTION;
import static lotto.util.Message.ErrorMessage.NOT_INTEGER_EXCEPTION;
import static lotto.util.Message.ErrorMessage.WINNING_NUMBER_EXCEPTION;
import static lotto.util.Message.ErrorMessage.LOTTO_NUMBER_EXCEPTION;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class Validator { //TODO: 예외 처리 후 다시 그 부분 받기
    private final String INPUT_REGEX = "^[0-9]*$";

    private void validateRegex(String input) {
        if (!input.matches(INPUT_REGEX)) {
            throw new IllegalArgumentException(NOT_INTEGER_EXCEPTION.getMessage());
        }
    }

    public void validateBudget(String input) {
        validateRegex(input);
        int budget = Integer.parseInt(input);
        if (!(budget % Constant.LOTTO_PRICE == Constant.ZERO && budget > 0)) {
            throw new IllegalArgumentException(BUDGET_EXCEPTION.getMessage());
        }
    }

    public void validateWinningNumber(String input) {
        isContainComma(input);
        ArrayList<String> winningNumber = Arrays
                .stream(input.split(Constant.COMMA))
                .collect(Collectors.toCollection(ArrayList::new));
        validateWinningNumberLength(winningNumber);
        for (String number : winningNumber) {
            validateRegex(number);
            validateLottoNumber(Integer.parseInt(number));
        }
        validateDuplication(winningNumber);
    }

    public void validateWinningNumberLength(ArrayList<String> winningNumber) {
        if (winningNumber.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(WINNING_NUMBER_EXCEPTION.getMessage());
        }
    }

    public void isContainComma(String input) {
        if (!input.contains(Constant.COMMA)) {
            throw new IllegalArgumentException(WINNING_NUMBER_EXCEPTION.getMessage());
        }
    }


    public void validateLottoNumber(int number) {
        if (!(number >= Constant.LOTTO_MIN_NUMBER && number <= Constant.LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_EXCEPTION.getMessage());
        }
    }

    public void validateDuplication(ArrayList<String> numbers) {
        Set<String> setNumbers = new HashSet<>(numbers);
        if (setNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(WINNING_NUMBER_EXCEPTION.getMessage());
        }
    }

    public void validateBonusNumber(String input, ArrayList<Integer> winningNumber) {
        validateRegex(input);
        int bonusNumber = Integer.parseInt(input);
        validateLottoNumber(bonusNumber);
        isDuplication(bonusNumber, winningNumber);
    }

    private void isDuplication(int number, ArrayList<Integer> winningNumber) {
        if (winningNumber.contains(number)) {
            throw new IllegalArgumentException(DUPLICATION_EXCEPTION.getMessage());
        }
    }

}
