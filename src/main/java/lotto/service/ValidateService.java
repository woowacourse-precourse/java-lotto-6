package lotto.service;

import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoNumber;
import lotto.constant.LottoPrice;

public class ValidateService {
    public int validateNumber(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER_ERROR.getMessage());
        }
    }

    public void validatePurchasePriceAll(int purchasePrice) {
        validatePrice(purchasePrice);
        validateCheckDivisibility(purchasePrice);
    }

    public void validateInputWinningNumbersAll(List<Integer> winningNumbers) {
        validateInputLottoRange(winningNumbers);
        validateDuplicateWinningNumber(winningNumbers);
        validateWinningNumbersCount(winningNumbers);
    }

    public void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateBonusNumberRange(bonusNumber);
        validateDuplicationWinningNumbersAndBonusNumber(bonusNumber, winningNumbers);
    }

    private void validatePrice(int purchasePrice) {
        if (purchasePrice < LottoNumber.LOTTO_PRICE.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.INSUFFICIENT_PRICE_MESSAGE.getMessage());
        }
    }

    private void validateCheckDivisibility(int purchasePrice) {
        if (purchasePrice % LottoNumber.LOTTO_PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(ErrorMessage.DIVISIBILITY_CHECK_AMOUNT.getMessage());
        }
    }

    private void validateInputLottoRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LottoNumber.START_NUMBER.getNumber() || number > LottoNumber.END_NUMBER.getNumber()) {
                throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER_OVER_RANGE_ERROR.getMessage());
            }
        }
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < LottoNumber.START_NUMBER.getNumber() || bonusNumber > LottoNumber.END_NUMBER.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER_OVER_RANGE_ERROR.getMessage());
        }

    }

    private void validateDuplicateWinningNumber(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_DUPLICATE_NUMBER_ERROR.getMessage());
        }
    }

    private void validateWinningNumbersCount(List<Integer> numbers) {
        if (numbers.size() != LottoNumber.LOTTO_COUNT.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_INCORRECT_NUMBER_COUNT_ERROR.getMessage());
        }
    }

    private void validateDuplicationWinningNumbersAndBonusNumber(int bonusNumber, List<Integer> numbers) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_DUPLICATE_BONUS_NUMBER_ERROR.getMessage());
        }
    }

}
