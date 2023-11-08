package lotto.validation;

import static lotto.exception.ExceptionMessage.DUPLICATED_LOTTO_NUMBERS;
import static lotto.exception.ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.exception.ExceptionMessage.INVALID_LOTTO_NUMBER_SIZE;
import static lotto.exception.ExceptionMessage.INVALID_PURCHASE_AMOUNT_MESSAGE;
import static lotto.utils.LottoConstant.LOTTO_END_NUMBER;
import static lotto.utils.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.utils.LottoConstant.LOTTO_START_NUMBER;
import static lotto.utils.LottoConstant.PURCHASE_AMOUNT_UNIT;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {

    public void verifyPurchaseAmount(String purchaseAmountInput) {
        int purchaseAmount;

        try {
            purchaseAmount = Integer.parseInt(purchaseAmountInput);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_MESSAGE.getMessage());
        }

        if (purchaseAmount <= 0 || purchaseAmount % PURCHASE_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_MESSAGE.getMessage());
        }
    }

    public void verifyWinNumbers(String lottoWinNumbersInput) {
        String[] numbers = lottoWinNumbersInput.split(",");

        if (numbers.length != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_SIZE.getMessage());
        }

        Set<Integer> winNumbersSet = new HashSet<>();

        for (String numberInput : numbers) {
            int number;

            try {
                number = Integer.parseInt(numberInput.trim());
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
            }

            if (!(LOTTO_START_NUMBER <= number && number <= LOTTO_END_NUMBER)) {
                throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
            }
            
            winNumbersSet.add(number);
        }

        if (winNumbersSet.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBERS.getMessage());
        }
    }

    public void verifyBonusNumber(List<Integer> winNumbers, String bonusNumberInput) {
        int bonusNumber;

        try {
            bonusNumber = Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }

        if (!(LOTTO_START_NUMBER <= bonusNumber && bonusNumber <= LOTTO_END_NUMBER)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }

        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBERS.getMessage());
        }
    }
}
