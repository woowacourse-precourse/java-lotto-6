package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constant.ErrorMessage.*;
import static org.assertj.core.api.Assertions.*;

class LottoTest {
    @Test
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외 발생")
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_COUNT_NOT_MATCHED);
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외 발생")
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_DUPLICATED);
    }

    @Test
    @DisplayName("범위 밖의 숫자가 로또 번호에 있으면 예외 발생")
    void createLottoOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(-1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NOT_IN_RANGE);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NOT_IN_RANGE);
    }

    @Test
    @DisplayName("로또 번호의 숫자가 오름차순 정렬되지 않은 경우 예외 발생")
    void createLottoNotSorted() {
        assertThatThrownBy(() -> new Lotto(List.of(6, 5, 4, 3, 2, 1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NOT_ASCENDING);
    }

    @Test
    @DisplayName("티켓에 로또 번호가 존재 하는지")
    void hasNumber() {
        Lotto ticket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(ticket.hasNumber(new LottoNumber(4))).isEqualTo(true);
        assertThat(ticket.hasNumber(new LottoNumber(7))).isEqualTo(false);
    }

    @Test
    @DisplayName("당첨 번호가 자료형 변환이 되는지")
    void from() {
        assertThatCode(() -> Lotto.from("1,2,3,4,5,6")).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 번호들이 정상 출력 되는지")
    void stringify() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        assertThat(new Lotto(numbers).toString())
                .contains(numbers.stream().map(String::valueOf).toList())
                .contains("[", "]");
    }
}