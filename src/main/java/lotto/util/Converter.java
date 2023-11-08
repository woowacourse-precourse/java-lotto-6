package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validation.BonusNumberValidator;
import lotto.validation.LottoException;
import lotto.validation.LottoNumbersValidator;
import lotto.validation.PurchaseValidator;

public class Converter {
    private static final String SPLIT_POINT = ",";

    public static int convertPurchaseAmount(String input) {
        try {
            int amount = Integer.parseInt(input);
            PurchaseValidator.validate(amount);
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoException.LETTER_ERROR_MESSAGE.getMessage());
        }
    }

    public static List<Integer> convertWinningNumbers(String input) {
        try {
            List<Integer> inputNumbers = Arrays.stream(input.split(SPLIT_POINT))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            LottoNumbersValidator.validate(inputNumbers);
            return inputNumbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoException.LETTER_ERROR_MESSAGE.getMessage());
        }
    }

    public static int convertBonusNumber(List<Integer> winningNumbers, String input) {
        try {
            int bonusNumber = Integer.parseInt(input);
            BonusNumberValidator.validate(winningNumbers, bonusNumber);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoException.LETTER_ERROR_MESSAGE.getMessage());
        }
    }
}
