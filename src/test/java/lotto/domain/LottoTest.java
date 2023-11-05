package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("isInLottoRange 메서드가 예상하는 값이 반환된다.")
    void isInLottoRange() {
        assertThat(Lotto.isInLottoRange(1)).isEqualTo(true);
        assertThat(Lotto.isInLottoRange(45)).isEqualTo(true);
        assertThat(Lotto.isInLottoRange(0)).isEqualTo(false);
        assertThat(Lotto.isInLottoRange(46)).isEqualTo(false);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 알맞게 정렬된다.")
    @Test
    void createLottoSorted() {
        Lotto lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        List<Integer> numbers = lotto.getNumbers();

        assertThat(numbers.get(0)).isEqualTo(1);
        assertThat(numbers.get(1)).isEqualTo(2);
        assertThat(numbers.get(2)).isEqualTo(3);
        assertThat(numbers.get(3)).isEqualTo(4);
        assertThat(numbers.get(4)).isEqualTo(5);
        assertThat(numbers.get(5)).isEqualTo(6);
    }
}