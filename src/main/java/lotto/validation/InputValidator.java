package lotto.validation;

import java.util.Arrays;
import java.util.List;
import lotto.exception.BonusNumberDuplicateException;
import lotto.exception.InputFormatException;
import lotto.exception.InvalidPurchaseAmountException;
import lotto.exception.LottoNumberRangeException;
import lotto.exception.NotIntegerException;
import lotto.exception.PurchaseAmountRangeException;
import lotto.exception.WinningNumberDuplicateException;
import lotto.exception.WinningNumberSizeException;

public class InputValidator {
    public static void validatePurchaseAmount(String input) {
        validateInteger(input);
        int purchaseAmount = Integer.parseInt(input);
        validateAmountLimit(purchaseAmount);
        validateDividedBy1000(purchaseAmount);
    }

    public static void validateWinningNumbersFormat(String input) {
        validateCommaFormat(input);
        String[] splitInput = input.split(",");
        Arrays.stream(splitInput).forEach(InputValidator::validateInteger);
    }

    public static void validateWinningNumbers(List<Integer> winningNumbers) {
        winningNumbers.forEach(InputValidator::validateLottoNumberRange);
        validateWinningNumbersSize(winningNumbers);
        validateDuplicateNumber(winningNumbers);
    }
    public static void validateBonusNumber(String input, List<Integer> winningNumbers) {
        validateInteger(input);
        int bonusNumber = Integer.parseInt(input);
        validateDuplicateBonusNumber(winningNumbers, bonusNumber);
        validateLottoNumberRange(bonusNumber);
    }

    private static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NotIntegerException();
        }
    }

    private static void validateLottoNumberRange(int number) {
        if(number < 1 || number > 45) {
            throw new LottoNumberRangeException();
        }
    }

    private static void validateAmountLimit(int purchaseAmount) {
        if (purchaseAmount > 100000) {
            throw new PurchaseAmountRangeException();
        }

        if (purchaseAmount < 1000) {
            throw new PurchaseAmountRangeException();
        }
    }

    private static void validateDividedBy1000(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new InvalidPurchaseAmountException();
        }
    }

    private static void validateCommaFormat(String input) {
        if(input.contains(",,") || input.startsWith(",") || input.endsWith(",")) {
            throw new InputFormatException();
        }
    }

    private static void validateWinningNumbersSize(List<Integer> winningNumbers) {
        if(winningNumbers.size() != 6) {
            throw new WinningNumberSizeException();
        }
    }
    private static void validateDuplicateNumber(List<Integer> numbers) {
        if(numbers.size() != numbers.stream().distinct().count()) {
            throw new WinningNumberDuplicateException();
        }
    }

    private static void validateDuplicateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if(winningNumbers.contains(bonusNumber)) {
            throw new BonusNumberDuplicateException();
        }
    }
}
