package lotto.domain;

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
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 범위에 일치하지 않는 숫자가 있으면 예외가 발생한다.")
    @Test
    void createOverRange(){
        assertThatThrownBy(() -> new Lotto(List.of(46, 0, -1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /*@DisplayName("구매 로또 번호와 당첨 내역이 일치하는지 확인한다.")
    @Test
    void checkSameNumber(){
        // given
        List<Integer> numbers = List.of(1,2,3,4,5,6);
        List<Integer> ticket = List.of(2,3,14,21,26,30);
        Lotto lotto = new Lotto(numbers);

        // when
        int sameCount = lotto.sameTicket(ticket);

        // then
        assertThat(sameCount).isEqualTo(2);
    }*/
}