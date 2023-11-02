package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.exception.ExceptionMessage.LottoException.LOTTO_SIZE_IS_NOT_FULFILL;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    @DisplayName("로또 번호의 개수가 6개를 초과하면 예외가 발생한다.")
    void throwExceptionByLottoSizeIsOver() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_SIZE_IS_NOT_FULFILL.message);
    }

    @Test
    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다.")
    void throwExceptionByLottoSizeIsLess() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_SIZE_IS_NOT_FULFILL.message);
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void throwExceptionByLottoNumberIsNotInRange() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
