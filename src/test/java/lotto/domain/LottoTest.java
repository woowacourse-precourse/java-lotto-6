package lotto.domain;

import lotto.constants.ErrorMessages;
import lotto.domain.Lotto;
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
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 6개보다 적으면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageMatching(ErrorMessages.INPUT_LOTTO_SIZE.getMessage());
    }

    @DisplayName("로또에 숫자가 아닌 값이 있으면 예외가 발생한다.")
    @Test
    void createLottoByNotNumber() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,a"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageMatching(ErrorMessages.INPUT_LOTTO_NUMERIC.getMessage());
    }

    @DisplayName("로또의 숫자가 범위를 넘어서면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,46"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageMatching(ErrorMessages.INPUT_LOTTO_RANGE.getMessage());
    }

    @DisplayName("로또의 숫자가 범위보다 작으면 예외가 발생한다.")
    @Test
    void createLottoByUnderRange() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,0"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageMatching(ErrorMessages.INPUT_LOTTO_RANGE.getMessage());
    }

    @DisplayName("리스트 타입으로 로또를 생성할 수 있다.")
    @Test
    void createLottoByIntegerList() {
        assertDoesNotThrow(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("스트링 타입으로 로또를 생성할 수 있다.")
    @Test
    void createLottoByString() {
        assertDoesNotThrow(() -> new Lotto("1,2,3,4,5,6"));
    }
}