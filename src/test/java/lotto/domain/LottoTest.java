package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

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

    @DisplayName("로또번호와 숫자들을 비교하여 포함된 숫자 개수 확인")
    @Test
    void lottoNumberCompareWithNumbers() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);

        //then
        assertThat(lotto.numberMatch(list)).isEqualTo(6);
    }

    @DisplayName("로또번호에 숫자가 포함되는지 확인")
    @Test
    void lottoNumberCompareWithNumber() {
        //given
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(list);

        //then
        for (Integer number : list) {
            assertThat(lotto.isMatch(number)).isTrue();
        }
        assertThat(lotto.isMatch(7)).isFalse();
    }

    @DisplayName("로또번호 문자열 반환")
    @Test
    void lottoNumberReturn() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);

        //then
        assertThat(lotto.getNumbers()).isEqualTo("1, 2, 3, 4, 5, 6");
    }
}