package lotto.validator.input;

import com.sun.jdi.request.DuplicateRequestException;
import lotto.exception.input.EmptyInputException;
import lotto.exception.input.NumberFormatException;

import java.util.List;

public class BonusNumberValidator {

    public int validateAndParse(String userInput, List<Integer> winningNumbers) {
        validateNotEmpty(userInput);
        validateIntegerFormat(userInput);
        int number = parseInteger(userInput);
        validateDuplicationWithWinningNumbers(number, winningNumbers);
        return number;
    }

    private void validateNotEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new EmptyInputException("입력이 비었습니다.");
        }
    }

    private void validateIntegerFormat(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("입력이 정수가 아닙니다.");
        }
    }

    private int parseInteger(String userInput) {
        return Integer.parseInt(userInput);
    }

    private void validateDuplicationWithWinningNumbers(int validatedNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(validatedNumber)) {
            throw new DuplicateRequestException("입력하신 번호는 당첨 번호와 중복됩니다.");
        }
    }
}
