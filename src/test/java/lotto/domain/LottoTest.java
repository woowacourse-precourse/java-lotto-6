package lotto.domain;

import static lotto.ErrorMessage.HAS_DUPLICATION_ERROR_MESSAGE;
import static lotto.ErrorMessage.WRONG_RANGE_ERROR_MESSAGE;
import static lotto.ErrorMessage.WRONG_SIZE_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WRONG_SIZE_ERROR_MESSAGE.get());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(HAS_DUPLICATION_ERROR_MESSAGE.get());
    }

    @Test
    @DisplayName("로또 번호가 1 이하 숫자를 포함하면 예외가 발생한다.")
    void createLottoByLessThan1Number() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 5, 7, 8, 15)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WRONG_RANGE_ERROR_MESSAGE.get());
    }

    @Test
    @DisplayName("로또 번호가 45보다 큰 수를 포함하면 예외가 발생한다.")
    void createLottoByGreaterThan45Number() {
        assertThatThrownBy(() -> new Lotto(List.of(46, 2, 5, 7, 8, 15)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WRONG_RANGE_ERROR_MESSAGE.get());
    }


}