package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.constants.ErrorMessage;

public class InputValidation {
    public static int validatePurchaseAmount(String input) {
        try {
            int purchaseAmount = Integer.parseInt(input);
            return purchaseAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NON_NUMERIC_PURCHASE.getMessage());
        }
    }

    public static List<Integer> validateWinningNumbers(String[] numbers) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            try {
                int number = Integer.parseInt(numbers[i]);
                lottoNumbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NON_NUMERIC.getMessage());
            }
        }
        return lottoNumbers;
    }

    public static int validateBonusNumber(String input) {
        try {
            int bonusNumber = Integer.parseInt(input);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NON_NUMERIC_PURCHASE.getMessage());
        }
    }
}
