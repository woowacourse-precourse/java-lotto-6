package lotto.global;

import static lotto.global.Constants.LOTTO_NUMBER_MAX;
import static lotto.global.Constants.LOTTO_NUMBER_MIN;
import static lotto.global.Constants.LOTTO_NUMBER_SIZE;
import static lotto.global.Constants.LOTTO_PRICE;
import static lotto.global.ErrorMessages.LOTTO_NUMBER_DUPLICATE_ERROR;
import static lotto.global.ErrorMessages.LOTTO_NUMBER_RANGE_ERROR;
import static lotto.global.ErrorMessages.LOTTO_NUMBER_SIZE_ERROR;
import static lotto.global.ErrorMessages.LOTTO_PRICE_ERROR;
import static lotto.global.ErrorMessages.LOTTO_PRICE_UNIT_ERROR;

import java.util.List;
import lotto.domain.Lotto;

public class Validator {

    public static void validateBonusNumber(Lotto winningLottoNumber, int bonusNumberInt) {
        if (winningLottoNumber.checkDuplicateNumber(bonusNumberInt)) {
            throw new CustomException(LOTTO_NUMBER_DUPLICATE_ERROR.getValue());
        }
        if (bonusNumberInt < LOTTO_NUMBER_MIN || bonusNumberInt > LOTTO_NUMBER_MAX) {
            throw new CustomException(LOTTO_NUMBER_RANGE_ERROR.getValue());
        }
    }

    public static void validateLotto(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new CustomException(LOTTO_NUMBER_SIZE_ERROR.getValue());
        }
        if (numbers.stream().distinct().count() != LOTTO_NUMBER_SIZE) {
            throw new CustomException(LOTTO_NUMBER_DUPLICATE_ERROR.getValue());
        }
        if (numbers.stream()
                .anyMatch(number -> number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX)) {
            throw new CustomException(LOTTO_NUMBER_RANGE_ERROR.getValue());
        }
    }

    public static void validateTickets(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new CustomException(LOTTO_PRICE_ERROR.getValue());
        }
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new CustomException(LOTTO_PRICE_UNIT_ERROR.getValue());
        }
    }
}