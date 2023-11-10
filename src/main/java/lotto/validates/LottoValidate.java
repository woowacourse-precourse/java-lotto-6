package lotto.validates;

import java.util.List;
import lotto.errors.LottoError;

public class LottoValidate {

    public static void validate(List<Integer> numbers, int bonusNumber) {
        sixLottoValidate(numbers);
        lottoNumberArrange(numbers);
        duplicatedBonusNumber(numbers, bonusNumber);
    }

    private static void sixLottoValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            LottoError lottoError = LottoError.NOT_SIX_LOTTO;
            throw new IllegalArgumentException(lottoError.getErrorMessage());
        }
    }

    private static void lottoNumberArrange(List<Integer> numbers) {
        for (int number : numbers) {
            if ((number < 1) || (number > 45)) {
                LottoError lottoError = LottoError.NOT_LOTTO_NUMBER_ARRANGE;
                throw new IllegalArgumentException(lottoError.getErrorMessage());
            }
        }
    }

    private static void duplicatedBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            LottoError lottoError = LottoError.DUPLICATED_BONUS_NUMBER;
            throw new IllegalArgumentException(lottoError.getErrorMessage());
        }
    }
}
