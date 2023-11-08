package lotto;

import java.util.ArrayList;
import java.util.List;

public class InputViewUtil {
    public static int getValidAmount(String input) throws IllegalArgumentException {
        int amount;
        try {
            amount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_NUMBER.getMessage());
        }

        if (amount % LottoManagement.PRICE_LOTTO != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE_LOTTO_PRICE.getMessage());
        }
        return amount;
    }

    public static List<Integer> getValidLottoNumbers(String input) throws IllegalArgumentException {
        String[] inputSplit = input.split(",");
        List<Integer> lottoNumbers = new ArrayList<>();
        if (inputSplit.length != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBERS.getMessage());
        }

        for (String str : inputSplit) {
            try {
                int number = Integer.parseInt(str);

                if (number < LottoConst.MIN_RANGE_NUMBER.getValue() || number > LottoConst.MAX_RANGE_NUMBER.getValue() || lottoNumbers.contains(number)) {
                    throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBERS.getMessage());
                }

                lottoNumbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBERS.getMessage());
            }
        }
        return lottoNumbers;
    }

    public static int getValidBonusNumber(String input, List<Integer> winningNumbers) throws IllegalArgumentException {
        try {
            int bonusNumber = Integer.parseInt(input);

            if (bonusNumber < LottoConst.MIN_RANGE_NUMBER.getValue() ||
                    bonusNumber > LottoConst.MAX_RANGE_NUMBER.getValue() ||
                    winningNumbers.contains(bonusNumber)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER.getMessage());
            }

            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER.getMessage());
        }
    }
}
