package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void 당첨_등수를_정확하게_매기는가() {
        //given
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 10);
        Lotto lotto1st = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2nd = new Lotto(List.of(1, 2, 3, 4, 5, 10));
        Lotto lotto3rd = new Lotto(List.of(1, 2, 3, 4, 5, 9));
        Lotto lotto4st = new Lotto(List.of(1, 2, 3, 4, 9, 11));
        Lotto lotto5st = new Lotto(List.of(1, 2, 3, 9, 11, 12));

        //then
        assertEquals(1, lotto1st.rank(winningLotto));
        assertEquals(2, lotto2nd.rank(winningLotto));
        assertEquals(3, lotto3rd.rank(winningLotto));
        assertEquals(4, lotto4st.rank(winningLotto));
        assertEquals(5, lotto5st.rank(winningLotto));
    }
}
