package lotto.controller.util.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.configuration.ErrorMessage;
import lotto.configuration.LottoConstants;

public class InputValidator {

    public void validateMoney(int money) {
        if (money < LottoConstants.LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ENOUGH_MONEY);
        }

        if (money % LottoConstants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.UNIT_NOT_VALID);
        }
    }

    public void validateWinningNumbers(List<Integer> drawNumbers) {
        isWinningNumberLengthCorrect(drawNumbers);

        isDuplicated(drawNumbers);

        drawNumbers.forEach(this::isNumberInRange);
    }

    private void isDuplicated(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);

        if (numbers.size() != numberSet.size()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATED);
        }
    }

    private void isWinningNumberLengthCorrect(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_LOTTO_NUMBER_LENGTH);
        }
    }

    public void validateBonusNumber(Integer number) {
        isNumberInRange(number);
    }

    private void isNumberInRange(Integer number) {
        if (number < LottoConstants.MIN_LOTTO_NUM || number > LottoConstants.MAX_LOTTO_NUM) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_NOT_IN_RANGE);
        }
    }
}
