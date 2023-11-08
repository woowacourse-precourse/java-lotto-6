package lotto.domain;

import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_LENGTH.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("로또 번호가 생성될 때 오름차 순으로 정렬된다.")
    @Test
    void checkLottoByAscOrder() {
        Lotto lotto = new Lotto(List.of(1, 4, 3, 2, 6, 5));
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("로또 번호의 범위가 1부터 45 사이가 아닌 경우 예외가 발생한다.")
    @Test
    void checkLottoNumberByRangeExcess() {
        assertThatThrownBy(() -> new Lotto(List.of(100, 1000, 10000, 100000, 1000000, 100000000)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NO_WITHIN_SCOPE_LOTTO_NUMBER.getMessage());
    }
}