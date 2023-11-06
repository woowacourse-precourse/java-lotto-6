package lotto.domain;

import java.util.List;
import lotto.constants.ErrorMessage;
import lotto.constants.LottoConstants;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        Assertions.assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        Assertions.assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개보다 적으면 예외가 발생한다.")
    @Test
    void createLotto_Fail_ByUnderSize() {
        // when, then
        Assertions.assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_LOTTO_NUMBERS_SIZE.getMessage()
                        .formatted(LottoConstants.LOTTO_NUMBERS_SIZE));
    }

    @DisplayName("로또 번호 중에서 1보다 작은 번호가 존재하면 예외가 발생한다.")
    @Test
    void createLotto_Fail_ByNumberIsLessThanMinimum() {
        // when, then
        Assertions.assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_LOTTO_NUMBERS_RANGE.getMessage()
                        .formatted(LottoConstants.MIN_LOTTO_NUMBER, LottoConstants.MAX_LOTTO_NUMBER));
    }

    @DisplayName("로또 번호 중에서 45보다 큰 번호가 존재하면 예외가 발생한다.")
    @Test
    void createLotto_Fail_ByNumberIsMoreThanMaximum() {
        // when, then
        Assertions.assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 66)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_LOTTO_NUMBERS_RANGE.getMessage()
                        .formatted(LottoConstants.MIN_LOTTO_NUMBER, LottoConstants.MAX_LOTTO_NUMBER));
    }

    @DisplayName("로또 번호가 특정 숫자를 포함할 경우 true를 반환한다.")
    @Test
    void contains_True() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when, then
        Assertions.assertThat(lotto.contains(1)).isTrue();
    }

    @DisplayName("로또 번호가 특정 숫자를 포함하지 않을 경우 false를 반환한다.")
    @Test
    void contains_False() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when, then
        Assertions.assertThat(lotto.contains(7)).isFalse();
    }
}
