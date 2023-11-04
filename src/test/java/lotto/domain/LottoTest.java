package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개보다 적다면 예외가 발생한다.")
    @Test
    void createLottoByLowerSize() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 범위에서 벗어난 숫자가 있으면 예외가 발생한다")
    @Test
    void createLottoByOutOfRangeNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

        @DisplayName("로또 번호가 서로 다른 6개의 숫자인 경우 예외가 발생하지 않는다")
    @Test
    void createLottoByDifferentSixNumbers() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatCode(() -> Lotto.from(List.of(1, 2, 3, 4, 5, 6)))
                .doesNotThrowAnyException();
    }
}
