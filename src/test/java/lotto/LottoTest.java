package lotto;

import static lotto.message.ErrorMessage.LOTTO_IS_NOT_SIX_DIGITS;
import static lotto.message.ErrorMessage.LOTTO_NUMBER_IS_DUPLICATED;
import static lotto.message.ErrorMessage.LOTTO_NUMBER_IS_NOT_IN_RANGE;
import static org.assertj.core.api.Assertions.assertThat;
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
                .hasMessageContaining(LOTTO_IS_NOT_SIX_DIGITS.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_IS_DUPLICATED.getMessage());
    }

    @DisplayName("로또 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByNumberNotInCorrectRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 50, 40, 60, 97, 100)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBER_IS_NOT_IN_RANGE.getMessage());
    }

    @DisplayName("로또 번호를 정렬하여 보여준다.")
    @Test
    void createLottoBySortedNumbers() {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).toString())
                .isEqualTo(new Lotto(List.of(6, 5, 4, 3, 2, 1)).toString());
    }
}