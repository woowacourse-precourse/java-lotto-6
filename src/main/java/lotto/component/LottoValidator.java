package lotto.component;

import static lotto.exception.ExceptionMessage.DUPLICATED_LOTTO_NUMBERS;
import static lotto.exception.ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.exception.ExceptionMessage.INVALID_LOTTO_NUMBER_SIZE;
import static lotto.exception.ExceptionMessage.INVALID_PURCHASE_AMOUNT_MESSAGE;
import static lotto.utils.IntegerConstant.ZERO;
import static lotto.utils.LottoConstant.LOTTO_END_NUMBER;
import static lotto.utils.LottoConstant.LOTTO_NUMBERS_SIZE;
import static lotto.utils.LottoConstant.LOTTO_START_NUMBER;
import static lotto.utils.LottoConstant.PURCHASE_AMOUNT_UNIT;
import static lotto.utils.StringConstant.COMMA;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {

    public void verifyPurchaseAmount(String purchaseAmountInput) {
        int purchaseAmount = parsingPurchaseAmount(purchaseAmountInput);
        ensurePurchaseAmountIsValid(purchaseAmount);
    }

    public void verifyWinNumbers(String lottoWinNumbersInput) {
        String[] numbers = lottoWinNumbersInput.split(COMMA);
        ensureNumbersHasLottoNumbersSize(numbers);

        Set<Integer> winNumbers = getWinNumbers(numbers);
        ensureNumbersIsNotDuplicated(winNumbers);
    }

    public void verifyBonusNumber(List<Integer> winNumbers, String bonusNumberInput) {
        int bonusNumber = parsingBonusNumberInput(bonusNumberInput);

        ensureNumberIsInLottoNumberRange(bonusNumber);
        ensureBonusNumberIsNotInWinNumbers(winNumbers, bonusNumber);
    }

    private Set<Integer> getWinNumbers(String[] numbers) {
        Set<Integer> winNumbers = new HashSet<>();

        for (String numberInput : numbers) {
            int number = parsingLottoNumberInput(numberInput);
            ensureNumberIsInLottoNumberRange(number);
            winNumbers.add(number);
        }
        return winNumbers;
    }

    private int parsingBonusNumberInput(String bonusNumberInput) {
        int bonusNumber;

        try {
            bonusNumber = Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }

        return bonusNumber;
    }

    private int parsingPurchaseAmount(String purchaseAmountInput) {
        int purchaseAmount;

        try {
            purchaseAmount = Integer.parseInt(purchaseAmountInput);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_MESSAGE.getMessage());
        }

        return purchaseAmount;
    }

    private int parsingLottoNumberInput(String numberInput) {
        int number;

        try {
            number = Integer.parseInt(numberInput.trim());
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }

        return number;
    }

    private void ensureNumberIsInLottoNumberRange(int number) {
        if (!(LOTTO_START_NUMBER <= number && number <= LOTTO_END_NUMBER)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private void ensureNumbersHasLottoNumbersSize(String[] numbers) {
        if (numbers.length != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_SIZE.getMessage());
        }
    }

    private void ensureNumbersIsNotDuplicated(Set<Integer> winNumbers) {
        if (winNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBERS.getMessage());
        }
    }

    private void ensurePurchaseAmountIsValid(int purchaseAmount) {
        if (purchaseAmount <= ZERO || purchaseAmount % PURCHASE_AMOUNT_UNIT != ZERO) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_MESSAGE.getMessage());
        }
    }

    private void ensureBonusNumberIsNotInWinNumbers(List<Integer> winNumbers, int bonusNumber) {
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBERS.getMessage());
        }
    }
}
