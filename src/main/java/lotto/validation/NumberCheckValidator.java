package lotto.validation;

import java.util.List;

import static lotto.messages.Constant.*;
import static lotto.messages.ErrorMessages.*;

public class NumberCheckValidator {
    public static void validateLottoNumber(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_LIST_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_SIZE);
        }
        if (lottoNumbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATION);
        }
        if (lottoNumbers.stream().anyMatch(i -> i < START_INCLUSIVE || i > END_INCLUSIVE)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE);
        }
    }

    public static void validateBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATION_WITH_WINNING_NUMBER);
        }
        if (bonusNumber < START_INCLUSIVE || bonusNumber > END_INCLUSIVE) {
            throw new IllegalArgumentException(BONUS_NUMBER_RANGE);
        }
    }
}