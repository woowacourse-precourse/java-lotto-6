package lotto.model;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ValueValidator {
    public boolean validatePurchasedPrice(String inputPurchasedPrice) {
        if (!validatePurchasedPriceValue(inputPurchasedPrice) && !validatePurchasedPriceValueRange(inputPurchasedPrice)) {
            return false;
        }
        return true;
    }

    private boolean validatePurchasedPriceValue(String inputPurchasedPrice) {
        if (!inputPurchasedPrice.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.ILLEGAL_NUMBER_FORMAT.getMessage());
        }
        return true;
    }

    private boolean validatePurchasedPriceValueRange(String inputPurchasedPrice) {
        int purchasedPrice = Integer.parseInt(inputPurchasedPrice);
        if (purchasedPrice < 1000) {
            throw new IllegalArgumentException(ErrorMessage.INSUFFICIENT_PURCHASE_AMOUNT.getMessage());
        }
        return true;
    }

    public boolean validateWinningInputValue(List<Integer> winningNumbers) {
        if (validateWinningInputValueSize(winningNumbers) && validateDuplicateWinningInputValue(winningNumbers)) {
            return false;
        }
        return true;
    }

    private boolean validateWinningInputValueSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.ILLEGAL_NUMBER_SIZE.getMessage());
        }
        return true;
    }

    private boolean validateDuplicateWinningInputValue(List<Integer> winningNumbers) {
        winningNumbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((number, count) -> {
                    if (count > 1) {
                        throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER.getMessage());
                    }
                });
        return true;
    }

    public boolean validateBonusNumber(String inputBonusNumber) {
        if (!validateBonusNumberValue(inputBonusNumber) && !validateBonusNumberValueRange(inputBonusNumber)) {
            return false;
        }
        return true;
    }

    public boolean validateBonusNumberValue(String inputBonusNumber) {
        if (!inputBonusNumber.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.ILLEGAL_NUMBER_FORMAT.getMessage());
        }
        return true;
    }

    public boolean validateBonusNumberValueRange(String inputBonusNumber) {
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.ILLEGAL_NUMBER_RANGE.getMessage());
        }
        return true;
    }
}
