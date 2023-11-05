package lotto.view;

import lotto.exception.DuplicateInputException;
import lotto.exception.InvalidInputException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    private static final String INVALID_INPUT_MESSAGE = "[ERROR] 금액에는 정수를 입력해주세요.";
    private static final String HAS_NOT_COMMA_MESSAGE = "[ERROR] 당첨 번호는 콤마로 구분해야 합니다.";
    private static final String NUMERIC = "^\\d+$";

    public void validateInputMoney(String inputMoney) {
        if (!isNumeric(inputMoney)) {
            throw new InvalidInputException(INVALID_INPUT_MESSAGE);
        }
    }

    private boolean hasComma(List<Integer> winningNumbers) {
        return winningNumbers.contains(",");
    }

    private boolean isNumeric(String inputMoney) {
        return inputMoney.matches(NUMERIC);
    }

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        if (isDuplicate(winningNumbers)) {
            throw new DuplicateInputException();
        }
        if (!hasComma(winningNumbers)) {
            throw new InvalidInputException(HAS_NOT_COMMA_MESSAGE);
        }
    }

    private boolean isDuplicate(List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        return uniqueNumbers.size() < winningNumbers.size();
    }

    public void validateBonusNumber(String bonusNumber) {
        if (!isNumeric(bonusNumber)) {
            throw new InvalidInputException(INVALID_INPUT_MESSAGE);
        }
    }
}
