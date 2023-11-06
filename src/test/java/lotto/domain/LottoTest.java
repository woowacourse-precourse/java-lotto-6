package lotto.domain;

import lotto.constants.Messages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Messages.ERROR_COUNT_LOTTO_NUMBER);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Messages.ERROR_DUPLICATE_LOTTO_NUMBER);
    }

    @DisplayName("로또 번호가 범위 밖 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByNumberOutsideRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 50)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Messages.ERROR_RANGE_LOTTO_NUMBER);
    }

    @Test
    @DisplayName("정상적 번호이면 로또 번호가 정상적으로 생성된다.")
    void shouldCreateLottoNumbersSuccessfully() {
        assertDoesNotThrow(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }
}
