package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;


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

    @Test
    void countMatchingNumbersTest() {
        Lotto myLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(myLotto.countMatchingNumbers(winningLotto, 7)).isEqualTo(2);
    }

    @Test
    void bonusMatchTrueTest() {
        Lotto myLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        assertThat(myLotto.bonusMatch(5, 7)).isEqualTo(true);
    }

    @Test
    void bonusMatchFalseByCountNotFive() {
        Lotto myLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        assertThat(myLotto.bonusMatch(1, 7)).isEqualTo(false);
    }

    @Test
    void bonusMatchFalseByBonusNumber() {
        Lotto myLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        assertThat(myLotto.bonusMatch(1, 10)).isEqualTo(false);
    }
}