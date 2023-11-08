package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constants.ErrorMessage.LOTTO_NUMBER_COUNT_ERROR_MESSAGE;
import static lotto.constants.ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE;
import static lotto.constants.ErrorMessage.LOTTO_NUMBER_RANGE_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_COUNT_ERROR_MESSAGE);
    }

    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_COUNT_ERROR_MESSAGE);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE);
    }

    @DisplayName("로또 번호가 1부터 45사이의 숫자가 아니라면 예외를 발생한다.")
    @Test
    void NumbersNotInRange1To45() {
        assertThatThrownBy(() -> new Lotto(List.of(46, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
    }

    @DisplayName("로또를 서로 비교해서 중복된 번호의 개수를 반환한다.")
    @Test
    void getDuplicatedNumberCount() {
        Lotto lotto = new Lotto(List.of(3, 6, 9, 12, 15, 18));

        int count = lotto.getDuplicatedNumberCount(new Lotto(List.of(10, 20, 30, 3, 6, 9)));

        Assertions.assertThat(count).isEqualTo(3);
    }

    @DisplayName("로또에 특정 번호가 중복되어 있는지 확인한다.")
    @Test
    void hasNumber() {
        Lotto lotto = new Lotto(List.of(3, 6, 9, 12, 15, 18));

        boolean bool = lotto.hasNumber(4);

        Assertions.assertThat(bool).isFalse();
    }
}