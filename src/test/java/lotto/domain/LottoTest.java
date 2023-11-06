package lotto.domain;

import static lotto.ErrorMessage.LOTTO_HAS_DUPLICATION_ERROR_MESSAGE;
import static lotto.ErrorMessage.LOTTO_WRONG_RANGE_ERROR_MESSAGE;
import static lotto.ErrorMessage.LOTTO_WRONG_SIZE_ERROR_MESSAGE;
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
                .hasMessage(LOTTO_WRONG_SIZE_ERROR_MESSAGE.get());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_HAS_DUPLICATION_ERROR_MESSAGE.get());
    }

    @Test
    @DisplayName("로또 번호가 1 이하 숫자를 포함하면 예외가 발생한다.")
    void createLottoByLessThan1Number() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 5, 7, 8, 15)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_WRONG_RANGE_ERROR_MESSAGE.get());
    }

    @Test
    @DisplayName("로또 번호가 45보다 큰 수를 포함하면 예외가 발생한다.")
    void createLottoByGreaterThan45Number() {
        assertThatThrownBy(() -> new Lotto(List.of(46, 2, 5, 7, 8, 15)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_WRONG_RANGE_ERROR_MESSAGE.get());
    }

    @Test
    @DisplayName("로또 클래스에 해당 숫자가 있으면 True를 리턴한다.")
    void testHasCaseTrue() {
        Lotto lotto = new Lotto(List.of(4, 11, 14, 42, 1, 7));

        assertThat(lotto.hasNumber(4)).isTrue();
        assertThat(lotto.hasNumber(42)).isTrue();
    }

    @Test
    @DisplayName("로또 클래스에 해당 숫자가 없으면 False를 리턴한다.")
    void testHasCaseFalse() {
        Lotto lotto = new Lotto(List.of(4, 11, 14, 42, 1, 7));

        assertThat(lotto.hasNumber(45)).isFalse();
        assertThat(lotto.hasNumber(12)).isFalse();
    }

    @Test
    @DisplayName("로또 클래스와 비교하여, 일치하는 갯수를 리턴한다")
    void testCountMatching() {
        Lotto lotto1 = new Lotto(List.of(5, 10, 15, 20, 25, 30));
        Lotto lotto2 = new Lotto(List.of(20, 25, 30, 35, 40, 45));

        int result = lotto1.countMatching(lotto2);
        int expected = 3;

        assertThat(result).isEqualTo(expected);
    }

}