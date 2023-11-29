package lotto.validation;

import static lotto.constant.ValidateMessage.WINNER_NUMBER_CANNOT_BE_NULL_OR_EMPTY;
import static lotto.constant.ValidateMessage.WINNER_NUMBER_IS_NOT_INTEGER;
import static lotto.constant.ValidateMessage.WINNER_NUMBER_VALIDATE_ERROR_INPUT;

import java.util.ArrayList;
import java.util.List;

public class WinnerNumberValidator {

    public void isNullOrEmpty(String winnerNumber) {
        if (winnerNumber == null || winnerNumber.length() == 0) {
            WINNER_NUMBER_CANNOT_BE_NULL_OR_EMPTY.throwException();
        }
    }

    public void validateErrorInput(String winnerNumber) {
        if (winnerNumber.contains(",,")) {
            WINNER_NUMBER_VALIDATE_ERROR_INPUT.throwException();
        }
        if (!Character.isDigit(winnerNumber.charAt(winnerNumber.length() - 1)) ||
                !Character.isDigit(winnerNumber.charAt(0))) {
            WINNER_NUMBER_VALIDATE_ERROR_INPUT.throwException();
        }
    }

    public List<Integer> isInteger(String winnerNumber) {
        String[] winnerNumberArray = winnerNumber.replace(" ", "").split(",");

        List<Integer> numbers = new ArrayList<>();

        for (String str : winnerNumberArray) {
            try {
                numbers.add(Integer.parseInt(str));
            } catch (NumberFormatException e) {
                WINNER_NUMBER_IS_NOT_INTEGER.throwException();
            }
        }
        return numbers;
    }
}
