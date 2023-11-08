package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validation.LottoException;

public class Converter {
    private static final String SPLIT_POINT = ",";

    public static int convertPurchaseAmount(String input) {
        try {
            int amount = Integer.parseInt(input);
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
            return inputNumbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoException.LETTER_ERROR_MESSAGE.getMessage());
        }
    }

    public static int convertBonusNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoException.LETTER_ERROR_MESSAGE.getMessage());
        }
    }
}
