package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.constant.ErrorMessage.LOTTO_NOT_IN_RANGE;
import static lotto.constant.ErrorMessage.LOTTO_NOT_NUMERIC;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @Test
    @DisplayName("범위 밖의 숫자로 로또 번호를 생성할 경우 예외 발생")
    void createLottoNumberNotNumeric() {
        assertThatThrownBy(() -> LottoNumber.from("이십이"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NOT_NUMERIC);
    }

    @Test
    @DisplayName("범위 밖의 숫자로 로또 번호를 생성할 경우 예외 발생")
    void createLottoNumberWithOutOfRange() {
        assertThatThrownBy(() -> new LottoNumber(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NOT_IN_RANGE);
        assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NOT_IN_RANGE);
    }
}
