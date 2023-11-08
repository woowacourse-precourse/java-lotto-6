package lotto.domain;

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
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumbers() {

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호에 포함되어 있으면 예외가 발생한다.")
    @Test
    void validateBonusNumber() {

        assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,5,6))
                .validateBonusNumber(new BonusNumber(5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void matchNumbersTest() {
        int result = 5;
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6))
                .matchNumbers(winningNumbers))
                .isEqualTo(result);
    }
}