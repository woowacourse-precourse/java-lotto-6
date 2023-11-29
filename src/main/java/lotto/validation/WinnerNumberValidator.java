package lotto.validation;

import static lotto.constant.Constant.MIN_LOTTO_NUMBER;
import static lotto.exception.ErrorInputException.ErrorMessage.WINNER_NUMBER_CANNOT_BE_NULL_OR_EMPTY;
import static lotto.exception.ErrorInputException.ErrorMessage.WINNER_NUMBER_ERROR_INPUT;
import static lotto.exception.ErrorInputException.ErrorMessage.WINNER_NUMBER_IS_MORE_THAN_ONE;
import static lotto.exception.ErrorInputException.ErrorMessage.WINNER_NUMBER_IS_NOT_INTEGER;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.ErrorInputException;

public class WinnerNumberValidator {
    public static void isBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new ErrorInputException(WINNER_NUMBER_CANNOT_BE_NULL_OR_EMPTY);
        }
    }

    public void checkCommaError(String input) {
        if (input.contains(",,")) {
            throw new ErrorInputException(WINNER_NUMBER_ERROR_INPUT);
        }
        if (!Character.isDigit(input.charAt(input.length() - 1)) || !Character.isDigit(input.charAt(0))) {
            throw new ErrorInputException(WINNER_NUMBER_ERROR_INPUT);
        }
    }

    public List<Integer> isInteger(String input) {
        String[] split = input.replace(" ", "").split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String s : split) {
            if (!isNumeric(s)) {
                throw new ErrorInputException(WINNER_NUMBER_IS_NOT_INTEGER);
            }
            numbers.add(Integer.parseInt(s));
        }
        return numbers;
    }


    private boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public List<Integer> moreThanOne(List<Integer> input) {
        boolean allMoreThanOne = input.stream().allMatch(integer -> integer >= MIN_LOTTO_NUMBER);
        if (!allMoreThanOne) {
            throw new ErrorInputException(WINNER_NUMBER_IS_MORE_THAN_ONE);
        }
        return input;
    }
}
