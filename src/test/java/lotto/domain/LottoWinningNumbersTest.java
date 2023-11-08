package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoWinningNumbersTest {

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new LottoWinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 범위가 1~45가 아니면 예외가 발생한다.")
    @Test
    void createLottoByWrongRange() {
        assertThatThrownBy(() -> new LottoWinningNumbers(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoWinningNumbers(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new LottoWinningNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 로또 번호가 있는지 확인한다.")
    @Test
    void containsNumber() {
        LottoWinningNumbers winningNumbers = new LottoWinningNumbers(List.of(1, 2, 3, 4, 5, 6));

        boolean result1 = winningNumbers.containsNumber(1);
        boolean result2 = winningNumbers.containsNumber(7);

        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
    }
}