package lotto.model;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ValueValidator {
    public boolean validatePurchasedPrice(String inputPurchasedPrice) {
        validatePurchasedPriceValue(inputPurchasedPrice);
        validatePurchasedPriceValueRange(inputPurchasedPrice);

        return true;
    }

    private void validatePurchasedPriceValue(String inputPurchasedPrice) {
        if (!inputPurchasedPrice.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.ILLEGAL_NUMBER_FORMAT.getMessage());
        }
    }

    private void validatePurchasedPriceValueRange(String inputPurchasedPrice) {
        int purchasedPrice = Integer.parseInt(inputPurchasedPrice);
        if (purchasedPrice < 1000) {
            throw new IllegalArgumentException(ErrorMessage.INSUFFICIENT_PURCHASE_AMOUNT.getMessage());
        }
    }

    public boolean validateWinningNumbersValue(List<Integer> winningNumbers) {
        validateWinningNumbersSize(winningNumbers);
        validateDuplicateWinningNumbers(winningNumbers);

        return true;
    }

    private void validateWinningNumbersSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.ILLEGAL_NUMBER_SIZE.getMessage());
        }
    }

    private void validateDuplicateWinningNumbers(List<Integer> winningNumbers) {
        winningNumbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((number, count) -> {
                    if (count > 1) {
                        throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER.getMessage());
                    }
                    if (number < 1 || number > 45) {
                        throw new IllegalArgumentException(ErrorMessage.ILLEGAL_NUMBER_RANGE.getMessage());
                    }
                });
    }

    public boolean validateBonusNumber(String inputBonusNumber) {
        validateBonusNumberValue(inputBonusNumber);
        validateBonusNumberValueRange(inputBonusNumber);

        return true;
    }

    private void validateBonusNumberValue(String inputBonusNumber) {
        if (!inputBonusNumber.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.ILLEGAL_NUMBER_FORMAT.getMessage());
        }
    }

    private void validateBonusNumberValueRange(String inputBonusNumber) {
        int bonusNumber = Integer.parseInt(inputBonusNumber);

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.ILLEGAL_NUMBER_RANGE.getMessage());
        }
    }
}
