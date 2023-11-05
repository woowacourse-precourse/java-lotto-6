package lotto.view;

import lotto.exception.DuplicateInputException;
import lotto.exception.InvalidInputException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    private static final String INVALID_INPUT_MESSAGE = "[ERROR] 금액에는 정수를 입력해주세요.";
    private static final String NUMERIC = "^\\d+$"; // 수정된 부분

    public void validateInputMoney(String inputMoney) {
        if (!isNumeric(inputMoney)) {
            throw new InvalidInputException(INVALID_INPUT_MESSAGE);
        }
    }

    private boolean isNumeric(String inputMoney) {
        return inputMoney.matches(NUMERIC);
    }

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        if (isDuplicate(winningNumbers)) {
            throw new DuplicateInputException();
        }
    }

    private boolean isDuplicate(List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        return uniqueNumbers.size() < winningNumbers.size();
    }
}
