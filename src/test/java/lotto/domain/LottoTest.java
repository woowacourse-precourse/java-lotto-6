package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 로또 번호에 중복된 숫자가 있습니다.";
    private static final String LENGTH_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LENGTH_ERROR_MESSAGE);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_ERROR_MESSAGE);
    }

    @DisplayName("로또 번호가 1보다 작은 경우 예외가 발생한다.")
    @Test
    void createLottoWithNumberLessThanRange() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(RANGE_ERROR_MESSAGE);
    }

    @DisplayName("로또 번호가 45보다 큰 경우 예외가 발생한다.")
    @Test
    void createLottoWithNumberGreaterThanRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(RANGE_ERROR_MESSAGE);
    }

    @DisplayName("로또 번호의 개수가 6개 미만인 경우 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LENGTH_ERROR_MESSAGE);
    }
}