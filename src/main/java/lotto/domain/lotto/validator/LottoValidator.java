package lotto.domain.lotto.validator;

import static lotto.domain.lotto.Lotto.LOTTO_NUMBERS_LENGTH;

import java.util.List;
import lotto.domain.lotto.exception.DuplicateBonusNumberException;
import lotto.domain.lotto.exception.DuplicateLottoNumberException;
import lotto.domain.lotto.exception.InvalidLottoLengthException;

public final class LottoValidator {

    private LottoValidator() {
    }

    /**
     * 입력된 로또 번호가 6자리인지 검증합니다. 6자리가 아닐 경우 예외가 발생합니다.
     */
    public static void validateLottoLength(final List lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_LENGTH) {
            throw new InvalidLottoLengthException();
        }
    }

    /**
     * 로또 번호가 중복이 존재할 때 예외를 던집니다.
     */
    public static void validateDuplication(final List lottoNumbers) {
        final int uniqueCount = (int) lottoNumbers.stream().distinct().count();
        if (uniqueCount != LOTTO_NUMBERS_LENGTH) {
            throw new DuplicateLottoNumberException();
        }
    }

    public static void validateDuplicationWithBonusNumber(
            final List<Integer> numbers,
            final int bonusNumber
    ) {
        validateBonusNumberDuplication(numbers, bonusNumber);
        validateDuplication(numbers);
    }

    private static void validateBonusNumberDuplication(
            final List<Integer> numbers,
            final int bonusNumber
    ) {
        if (numbers.contains(bonusNumber)) {
            throw new DuplicateBonusNumberException();
        }
    }
}
