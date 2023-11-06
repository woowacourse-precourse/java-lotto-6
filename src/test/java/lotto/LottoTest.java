package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
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

    @DisplayName("로또 번호에 1~45 이외의 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 숫자를 비교하여 해당 숫자가 포함되어 있는지 확인한다.")
    @Test
    void contains() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        boolean result = lotto.contains(1);

        assertThat(result).isTrue();
    }

    @DisplayName("로또 번호와 당첨번호를 비교하여 몇개의 번호가 일치하는지 확인한다.")
    @Test
    void compareLottoWithWinningNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 7, 8, 9));

        int result = lotto.compareLottoWithWinningNumber(winningNumber);

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("로또의 번호들을 가져온다.")
    @Test
    void getNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        List<Integer> result = lotto.getNumbers();
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);

        assertThat(result).isEqualTo(expected);
    }
}