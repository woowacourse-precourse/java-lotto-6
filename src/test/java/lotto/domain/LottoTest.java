package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.");
    }

    @DisplayName("로또 번호가 정렬 되어 있지 않으면 예외가 발생한다.")
    @Test
    void 로또번호_정렬_검사() {
        assertThatThrownBy(() -> new Lotto(List.of(2, 1, 4, 3, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("로또 번호가 정렬 되어 있지 않으면 예외가 발생한다.");
    }

    @DisplayName("로또 번호에 1~45 이외의 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또번호_범위_검사() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("로또 번호에 1~45 이외의 숫자가 있으면 예외가 발생한다.");
    }
}