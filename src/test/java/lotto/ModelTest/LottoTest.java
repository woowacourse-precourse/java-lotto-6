package lotto.ModelTest;

import lotto.Lotto;
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

    @DisplayName("로또 번호의 개수가 6개보다 작으면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 범위를 벗어나면 예외가 발생한다")
    @Test
    void createLottoByUnderflowNumber()
    {
        assertThatThrownBy(() -> new Lotto(List.of(-1, -1, -1, -1, -1, -1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 범위를 벗어나면 예외가 발생한다")
    @Test
    void createLottoByOverflowNumber()
    {
        assertThatThrownBy(() -> new Lotto(List.of(46, 46, 46, 46, 46, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다른 Lotto 객체와 비교할 때 공통된 원소 개수를 찾는다")
    @Test
    void compareOtherLottoObject()
    {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(4, 5, 6, 7, 8, 9));
        assertThat(lotto1.compare(lotto2) == 3);
    }

    @DisplayName("Lotto 객체가 해당 원소를 가지고 있는지 true/false로 반환한다")
    @Test
    void checkContainingSpecificNumber()
    {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.contains(1) && !lotto.contains(7));
    }

    @DisplayName("Lotto를 String으로 변환할 때 [e, e, e, e, e, e]형으로 변환된다")
    @Test
    void toStringRightFormat()
    {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.toString() == "[1, 2, 3, 4, 5, 6]");
    }
}