package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constant.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외 발생")
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_COUNT_NOT_MATCHED);
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외 발생")
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_DUPLICATED);
    }

    @Test
    @DisplayName("범위 밖의 숫자가 로또 번호에 있으면 예외 발생")
    void createLottoNotInRange() {
        assertThatThrownBy(() -> new Lotto(List.of(-1, 0, 1, 2, 45, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NOT_IN_RANGE);
    }

    @Test
    @DisplayName("로또 번호의 숫자가 오름차순 정렬되지 않은 경우 예외 발생")
    void createLottoNotSorted() {
        assertThatThrownBy(() -> new Lotto(List.of(6, 5, 4, 3, 2, 1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NOT_ASCENDING);
    }
}