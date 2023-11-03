package lotto.domain.lotto.validator;

import static lotto.domain.lotto.Lotto.LOTTO_NUMBERS_LENGTH;

import java.util.List;

public final class LottoValidator {

    private LottoValidator() {
    }

    /**
     * 입력된 로또 번호가 6자리인지 검증합니다. 6자리가 아닐 경우 예외가 발생합니다.
     */
    public static void validateLotto(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
