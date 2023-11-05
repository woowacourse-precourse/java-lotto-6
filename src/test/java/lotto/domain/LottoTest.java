package lotto.domain;

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
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 포함되어 있으면 true를 반환한다")
    @Test
    void containsNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.containsNumber(3)).isTrue();
    }

    @DisplayName("로또 번호 주어지면 일치하는 숫자의 개수를 반환한다.")
    @Test
    void getCountingMatchingNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        lotto.getCountingMatchingNumbers(new Lotto(List.of(2, 3, 4, 5, 6, 7)));
    }
}