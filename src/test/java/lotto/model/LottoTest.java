package lotto.model;

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

    @DisplayName("로또 번호에 1~45 이외에 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByRangedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 100)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 맞은_개수가_6개다() {
        //given
        Lotto wining = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when & then
        assertThat(lotto.countCorrectNumbers(wining)).isEqualTo(6);
    }

    @Test
    void 맞은_개수가_5개다() {
        //given
        Lotto wining = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        //when & then
        assertThat(lotto.countCorrectNumbers(wining)).isEqualTo(5);
    }

    @Test
    void 맞은_개수가_4개다() {
        //given
        Lotto wining = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 8, 9));

        //when & then
        assertThat(lotto.countCorrectNumbers(wining)).isEqualTo(4);
    }

    @Test
    void 맞은_개수가_3개다() {
        //given
        Lotto wining = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));

        //when & then
        assertThat(lotto.countCorrectNumbers(wining)).isEqualTo(3);
    }

}