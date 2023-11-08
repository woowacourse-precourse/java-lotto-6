package lotto.exception;

import java.util.Arrays;
import java.util.List;

public class InvalidWinningNumbersException extends UserInvalidInputException {
    public InvalidWinningNumbersException(String message, String invalidInput, Throwable cause) {
        super(message, invalidInput, cause);
    }

    public InvalidWinningNumbersException(String message, List<Integer> invalidNumbers) {
        super(message, Arrays.toString(invalidNumbers.toArray()));
    }

    public InvalidWinningNumbersException(String message, List<Integer> invalidNumbers, Throwable cause) {
        super(message, Arrays.toString(invalidNumbers.toArray()), cause);
    }
}
