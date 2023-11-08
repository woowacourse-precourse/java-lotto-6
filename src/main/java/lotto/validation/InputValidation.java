package lotto.validation;

import static lotto.constant.ErrorMessage.DIGIT_EXCEPTION;
import static lotto.constant.ErrorMessage.DUPLICATION_EXCEPTION;
import static lotto.constant.ErrorMessage.MULTIPLE_EXCEPTION;
import static lotto.constant.ErrorMessage.NULL_EXCEPTION;
import static lotto.constant.ErrorMessage.NUMBER_IN_RANGE_EXCEPTION;
import static lotto.constant.ErrorMessage.SIZE_EXCEPTION;
import static lotto.constant.LottoConstant.LAST_LOTTO_NUMBER;
import static lotto.constant.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.constant.LottoConstant.LOTTO_PRICE;
import static lotto.constant.LottoConstant.START_LOTTO_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidation {
    private static final String DELIMITER = ",";

    public void validatePurchaseCost(String purchaseCost) {
        validateBlank(purchaseCost);
        validateDigit(purchaseCost);
        validateMultiple(purchaseCost);
    }

    public void validateWinningNumber(String winningNumberInput) {
        validateBlank(winningNumberInput);

        String[] winningNumbers = winningNumberInput.split(DELIMITER);
        validateSize(winningNumbers);

        Set<Integer> distinctWinningNumbers = new HashSet<>();
        for (String eachNumber : winningNumbers) {
            validateDigit(eachNumber);

            int winningNumber = Integer.parseInt(eachNumber);
            validateNumberInRange(winningNumber);
            validateDuplication(winningNumber, distinctWinningNumbers);
        }
    }

    public void validateBonusNumber(String bonusNumberInput, List<Integer> winningNumbers) {
        validateBlank(bonusNumberInput);
        validateDigit(bonusNumberInput);

        Set<Integer> distinctWinningNumbers = new HashSet<>(winningNumbers);
        int bonusNumber = Integer.parseInt(bonusNumberInput);
        validateNumberInRange(bonusNumber);
        validateDuplication(bonusNumber, distinctWinningNumbers);
    }

    private void validateBlank(String info) {
        if (isBlank(info)) {
            throw new IllegalArgumentException(NULL_EXCEPTION.getMessage());
        }
    }

    private boolean isBlank(String info) {
        return info == null || info.isBlank();
    }

    private void validateDigit(String info) {
        try {
            Integer.parseInt(info);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(DIGIT_EXCEPTION.getMessage());
        }
    }

    private void validateMultiple(String info) {
        int money = Integer.parseInt(info);
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(MULTIPLE_EXCEPTION.getMessage());
        }
    }

    private void validateSize(String[] winningNumbers) {
        if (winningNumbers.length != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(SIZE_EXCEPTION.getMessage());
        }
    }

    private void validateNumberInRange(int winningNumber) {
        if (!isNumberInRange(winningNumber)) {
            throw new IllegalArgumentException(NUMBER_IN_RANGE_EXCEPTION.getMessage());
        }
    }

    private boolean isNumberInRange(int winningNumber) {
        return START_LOTTO_NUMBER <= winningNumber && winningNumber <= LAST_LOTTO_NUMBER;
    }

    private void validateDuplication(int winningNumber, Set<Integer> distinctWinningNumbers) {
        if (!distinctWinningNumbers.add(winningNumber)) {
            throw new IllegalArgumentException(DUPLICATION_EXCEPTION.getMessage());
        }
    }
}
