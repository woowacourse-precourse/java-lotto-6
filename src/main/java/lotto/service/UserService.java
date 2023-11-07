package lotto.service;

import lotto.domain.Constants;
import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;

public class UserService {
    private void validateStringToNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constants.NOT_INT_NUMBER_ERROR);
        }
    }

    private void validateLottoNumberRange(Integer number) {
        if (number < Constants.MIN_LOTTO_NUM || number > Constants.MAX_LOTTO_NUM) {
            throw new IllegalArgumentException(Constants.LOTTO_NUMBER_RANGE_ERROR);
        }
    }

    public Integer getPrice(String price) {
        validateStringToNumber(price);
        validatePriceInput(price);

        return Integer.parseInt(price);
    }

    private void validatePriceInput(String price) {
        if (Integer.parseInt(price) % Constants.PRICE_UNIT != 0) {
            throw new IllegalArgumentException(Constants.NOT_UNIT_PRICE_ERROR);
        }
    }

    public Lotto getWinningLotto(String winningNumber) {
        validateWinningNumberInput(winningNumber);

        return new Lotto(
                Arrays.stream(winningNumber.split(","))
                .map(Integer::parseInt)
                .toList());
    }

    private void validateWinningNumberInput(String winningNumber) {
        List<String> numbers = List.of(winningNumber.split(","));

        if (numbers.size() != Constants.LOTTO_LENGTH) {
            throw new IllegalArgumentException(Constants.LOTTO_LENGTH_ERROR);
        }

        for (String number: numbers) {
            validateStringToNumber(number);
            validateLottoNumberRange(Integer.parseInt(number));
        }
    }

    public Integer getBonusNumber(String bonusNumber, Lotto winningLotto) {
        validateStringToNumber(bonusNumber);
        validateLottoNumberRange(Integer.parseInt(bonusNumber));
        validateBonusNumberInput(Integer.parseInt(bonusNumber), winningLotto.getNumbers());

        return Integer.parseInt(bonusNumber);
    }

    private void validateBonusNumberInput(Integer bonusNumber, List<Integer> winningNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(Constants.DUPLICATE_NUMBER_ERROR);
        }
    }
}
