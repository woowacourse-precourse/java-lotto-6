package lotto.domain.lotto.boxed;

import java.util.Objects;
import lotto.domain.lotto.exception.InvalidLottoNumberException;

/**
 * 6자리의 로또 번호 중, 각 자리를 나타내는 LottoNumber는 하나의 `int` 필드를 갖는 Wrapper class 입니다. `int`로 생성 가능하며, 생성 시 검증하여 유효성 보장이 가능합니다.
 */
public sealed class LottoNumber permits BonusNumber {

    /**
     * 최소 로또 번호는 1입니다.
     */
    public static final int MIN_LOTTO_NUMBER = 1;
    /**
     * 최대 로또 번호는 45입니다.
     */
    public static final int MAX_LOTTO_NUMBER = 45;
    /**
     * 실제 Primitive Value
     */
    protected final int value;

    /**
     * @apiNote LottoNumber 생성 시, <h3 color="#bf0f4d">value는 반드시 1 이상 45 이하의 범위에 속해야 합니다.</h3>
     */
    public LottoNumber(final int value) {
        validateLottoNumber(value);
        this.value = value;
    }

    /**
     * 각 자리의 로또 번호를 생성할 때, 1~45 사이의 숫자인지 검증합니다. 범위를 벗어난다면 `InvalidLottoNumberException` 예외가 발생합니다.
     */
    private static void validateLottoNumber(final int lottoNumber) {
        if (lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER) {
            throw new InvalidLottoNumberException();
        }
    }

    /**
     * Boxed Class의 내부 필드값을 복사하여 반환합니다.
     */
    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null ||
                (o.getClass() != LottoNumber.class && o.getClass() != BonusNumber.class) ||
                (getClass() != LottoNumber.class && getClass() != BonusNumber.class)
        ) {
            return false;
        }
        final LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public LottoNumber clone() {
        return new LottoNumber(value);
    }

}
