package lotto.domain;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static constant.MessageList.*;

public class InputValidator {

    public InputValidator() {
    }

    // 구입 금액에 대한 검증
    public int validatePurchaseAmount(String purchaseAmountFromPlayer) {
        int purchaseAmount = validateNumber(purchaseAmountFromPlayer);
        validatePositiveNumber(purchaseAmount);
        validateDivisible(purchaseAmount);
        return purchaseAmount;
    }

    private int validateNumber(String purchaseAmountFromPlayer) {
        try {
            return Integer.parseInt(purchaseAmountFromPlayer);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_INPUT_IS_NOT_NUMBER);
        }
    }

    private void validatePositiveNumber(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(ERROR_INPUT_IS_NOT_POSITIVE_NUMBER);
        }
    }

    private void validateDivisible(int purchaseAmount) {
        if (purchaseAmount / PRICE_OF_ONE_LOTTO == 0) {
            throw new IllegalArgumentException(ERROR_INPUT_IS_NOT_DIVISIBLE);
        }
    }

    // 당첨 번호에 대한 검증
    public List<Integer> validateWinningNumbers(String winningNumberFromPlayer) {
        List<Integer> winningNumber = validateInput(winningNumberFromPlayer);
        for (int number : winningNumber) {
            validateRangeOfNumber(number);
        }
        validateSizeOfNumber(winningNumber);
        validateDuplicate(winningNumber);
        return winningNumber;
    }

    private List<Integer> validateInput(String winningNumberFromPlayer) {
        try {
            List<String> temporary = Arrays.asList(winningNumberFromPlayer.split(","));
            List<Integer> winningNumber = temporary.stream()
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
            return winningNumber;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_INVALID_INPUT);
        }
    }

    private void validateRangeOfNumber(int number) {
        if (!(number >= 1 && number <= 45)) {
            throw new IllegalArgumentException(ERROR_INPUT_IS_NOT_IN_PROPER_RANGE);
        }
    }

    private void validateSizeOfNumber(List<Integer> winningNumber) {
        if (winningNumber.size() != 6) {
            throw new IllegalArgumentException(ERROR_INPUT_HAS_NOT_PROPER_SIZE);
        }
    }

    private void validateDuplicate(List<Integer> winningNumber) {
        HashSet<Integer> winningNumberSet = new HashSet<>(winningNumber);
        if (winningNumberSet.size() < winningNumber.size()) {
            throw new IllegalArgumentException(ERROR_INPUT_HAS_DUPLICATED_NUMBER);
        }
    }

    // 보너스 번호에 대한 검증
    public int validateBonusNumber(String bonusNumberFromPlayer, List<Integer> winningNumber) {
        int bonusNumber = validateNumber(bonusNumberFromPlayer);
        validatePositiveNumber(bonusNumber);
        validateRangeOfNumber(bonusNumber);
        validateDuplicateOfWinningNumber(bonusNumber, winningNumber);
        return bonusNumber;
    }

    private void validateDuplicateOfWinningNumber(int bonusNumber, List<Integer> winningNumber) {
        for (int i = 0; i < winningNumber.size(); i++) {
            if (bonusNumber == winningNumber.get(i)) {
                throw new IllegalArgumentException(ERROR_DUPLICATE_OF_WINNING_NUMBER);
            }
        }
    }
}
