package lotto.view;

import static lotto.exception.ExceptionMessage.EMPTY_INPUT;
import static lotto.exception.ExceptionMessage.INVALID_DUPLICATE_NUMBER;
import static lotto.exception.ExceptionMessage.INVALID_INPUT_NOT_INTEGER_ERROR;
import static lotto.exception.ExceptionMessage.INVALID_NUMBER_RANGE;
import static lotto.exception.ExceptionMessage.INVALID_PURCHASE_AMOUNT;
import static lotto.exception.ExceptionMessage.INVALID_RANGE_OF_BONUS_NUMBER;
import static lotto.exception.ExceptionMessage.INVALID_WINNING_NUMBER_LENGTH;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputValidator {

    private static final int LOTTO_PRICE = 1000;

    public int validateInputMoney(String purchaseAmount) {
        validateNumeric(purchaseAmount);
        int purchaseMoney = Integer.parseInt(purchaseAmount);
        validatePurchaseAmount(purchaseMoney);
        return purchaseMoney;
    }

    public void validateNumeric(String targetNumber) {
        if (!targetNumber.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(INVALID_INPUT_NOT_INTEGER_ERROR.getErrorMessage());
        }
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0 || purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getErrorMessage());
        }
    }

    public int validateBonusNumber(List<Integer> winningNumbers, String bonusNumberInput) {
        validateNumeric(bonusNumberInput);
        int bonusNumber = Integer.parseInt(bonusNumberInput);
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberNotInLottoNumbers(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    public List<Integer> validateAndParseWinningNumbers(String winningNumbersInput) {
        validateInput(winningNumbersInput);
        List<Integer> winningNumbers = parseWinningNumbers(winningNumbersInput);
        validateWinningNumbersCount(winningNumbers);
        validateNoDuplicateNumbers(winningNumbers);
        validateRangeOfNumbers(winningNumbers);
        return winningNumbers;
    }

    private void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT.getErrorMessage());
        }
    }

    private List<Integer> parseWinningNumbers(String winningNumbersInput) {
        try {
            return Arrays.stream(winningNumbersInput.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_NOT_INTEGER_ERROR.getErrorMessage());
        }
    }

    private void validateWinningNumbersCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_LENGTH.getErrorMessage());
        }
    }

    private void validateNoDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(INVALID_DUPLICATE_NUMBER.getErrorMessage());
        }
    }

    private void validateRangeOfNumbers(List<Integer> numbers) {
        boolean outOfRange = numbers.stream()
                .anyMatch(number -> number < 1 || number > 45);

        if (outOfRange) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getErrorMessage());
        }
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber <= 0 || bonusNumber > 45) {
            throw new IllegalArgumentException(INVALID_RANGE_OF_BONUS_NUMBER.getErrorMessage());
        }
    }

    private void validateBonusNumberNotInLottoNumbers(int bonusNumber, List<Integer> winningLottoNumber) {
        if (winningLottoNumber.stream().anyMatch(number -> number == bonusNumber)) {
            throw new IllegalArgumentException(INVALID_DUPLICATE_NUMBER.getErrorMessage());
        }
    }
}
