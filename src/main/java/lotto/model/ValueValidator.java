package lotto.model;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ValueValidator {
    public boolean validatePurchasedPriceValue(String inputPurchasedPrice) {
        if (!inputPurchasedPrice.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.ILLEGAL_NUMBER_FORMAT.getMessage());
        }
        return true;
    }

    public boolean validatePurchasedPriceValueRange(String inputPurchasedPrice) {
        int purchasedPrice = Integer.parseInt(inputPurchasedPrice);
        if (purchasedPrice < 1000) {
            throw new IllegalArgumentException(ErrorMessage.INSUFFICIENT_PURCHASE_AMOUNT.getMessage());
        }
        return true;
    }

    public boolean validateWinningInputValue(List<Integer> winningNumbers) {
        winningNumbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((number, count) -> {
                    if (count > 1) {
                        throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER.getMessage());
                    }
                });
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
