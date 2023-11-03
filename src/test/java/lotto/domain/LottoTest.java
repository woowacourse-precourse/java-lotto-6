package lotto.domain;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개가 아니면 예외처리.")
    @Test
    void createLottoByOverSize2() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("45보다 큰 경우")
    @Test
    void createLottoOutOfRange1() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 46, 4, 23, 30)))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("1보다 작은 경우")
    @Test
    void createLottoOutOfRange2() {
        assertThatThrownBy(() -> new Lotto(List.of(-1, 2, 40, 4, 23, 30)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}