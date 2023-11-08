package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1 ~ 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoByInvalidNumber() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호는 오름차순 정렬되어있다")
    @Test
    void sortLottoNumber() {
        Lotto lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        assertThat(lotto).hasToString("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("로또를 비교하여 일치하는 숫자 개수를 리턴한다")
    @Test
    void getMatchCountBetweenTwoLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto otherLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        assertThat(lotto.countMatchNumber(otherLotto)).isEqualTo(5);
    }

    @DisplayName("발행한 로또에 포함된 숫자면 true 리턴한다")
    @Test
    void trueIfContainNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.contains(1)).isTrue();
    }

    @DisplayName("발행한 로또에 포함되지 않은 숫자면 false 리턴한다")
    @Test
    void falseIfNotContainNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.contains(7)).isFalse();
    }
}
