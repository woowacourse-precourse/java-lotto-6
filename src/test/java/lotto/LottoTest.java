package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Assertions;
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

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("특정 숫자가 포함되어 있으면 true를 반환한다.")
    @Test
    void containsNumberTest1() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        Assertions.assertTrue(lotto.containsNumber(1));
        Assertions.assertTrue(lotto.containsNumber(3));
        Assertions.assertTrue(lotto.containsNumber(6));
    }

    @DisplayName("특정 숫자가 포함되어 있지 않으면 false를 반환한다.")
    @Test
    void containsNumberTest2() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        Assertions.assertFalse(lotto.containsNumber(0));
        Assertions.assertFalse(lotto.containsNumber(7));
        Assertions.assertFalse(lotto.containsNumber(10));
    }
}