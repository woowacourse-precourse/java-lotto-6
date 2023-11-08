package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoWinningNumbersTest {
    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinningLottoByOverSize() {
        assertThatThrownBy(() -> new LottoWinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new LottoWinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 5)), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 1~45 범위 밖의 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningLottoByOverNumber() {
        assertThatThrownBy(() -> new LottoWinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 66)), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45 범위 밖의 숫자이면 예외가 발생한다.")
    @Test
    void createBonusNumberByOverNumber() {
        assertThatThrownBy(() -> new LottoWinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 55))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 중 보너스 번호와 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> new LottoWinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }


}