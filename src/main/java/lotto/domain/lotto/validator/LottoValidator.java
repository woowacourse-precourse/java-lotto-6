package lotto.domain.lotto.validator;

import static lotto.domain.lotto.Lotto.NUMBERS_COUNT;

import java.util.List;
import lotto.domain.lotto.exception.DuplicateBonusNumberException;
import lotto.domain.lotto.exception.DuplicateLottoNumberException;
import lotto.domain.lotto.exception.InvalidLottoLengthException;

/**
 * Lotto 생성 시, 비즈니스 요구 사항 검증에 사용됩니다.
 */
public final class LottoValidator {

    /**
     * 외부 생성자 접근을 제한합니다.
     */
    private LottoValidator() {
    }

    /**
     * 입력된 로또 번호가 6자리인지 검증합니다. 6자리가 아닐 경우 예외가 발생합니다.
     */
    public static void validateLottoLength(final List lottoNumbers) {
        if (lottoNumbers.size() != NUMBERS_COUNT) {
            throw new InvalidLottoLengthException();
        }
    }

    /**
     * 로또 번호가 중복이 존재할 때 예외를 던집니다.
     */
    public static void validateDuplication(final List lottoNumbers) {
        final int uniqueCount = (int) lottoNumbers.stream().distinct().count();
        if (uniqueCount != NUMBERS_COUNT) {
            throw new DuplicateLottoNumberException();
        }
    }

    /**
     * 로또 번호 중복이 있는지 검사하고,
     * <p>
     * 보너스 번호가 로또 번호와 충돌하는지 검사합니다.
     */
    public static void validateDuplicationWithBonusNumber(
            final List<Integer> numbers,
            final int bonusNumber
    ) {
        validateBonusNumberDuplication(numbers, bonusNumber);
        validateDuplication(numbers);
    }

    /**
     * 보너스 번호가 로또 번호와 충돌하는지 검사합니다.
     */
    private static void validateBonusNumberDuplication(
            final List<Integer> numbers,
            final int bonusNumber
    ) {
        if (numbers.contains(bonusNumber)) {
            throw new DuplicateBonusNumberException();
        }
    }
}
