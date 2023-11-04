package lotto.entity;

import lotto.entity.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void 로또_생성_실패_번호_개수_부족() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_생성_실패_번호_범위_미만() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_생성_실패_번호_범위_초과() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5,46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_생성_성공() {
        Lotto input = new Lotto(List.of(11,12,13,14,15,16));
        List<Integer> result = List.of(11,12,13,14,15,16);

        assertThat(input.getNumbers())
                .containsAll(result);
    }

    @Test
    void 로또_당첨_검증_1등() {
        Lotto input = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto prize = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 45;
        int resultPrize = 1;

        assertThat(input.checkWin(prize, bonusNumber))
                .isEqualTo(resultPrize);
    }

    @Test
    void 로또_당첨_검증_2등() {
        Lotto input = new Lotto(List.of(1, 2, 3, 4, 5, 45));
        Lotto prize = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 45;
        int resultPrize = 2;

        assertThat(input.checkWin(prize, bonusNumber))
                .isEqualTo(resultPrize);
    }

    @Test
    void 로또_당첨_검증_3등() {
        Lotto input = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto prize = new Lotto(List.of(1, 2, 3, 4, 5, 11));
        int bonusNumber = 45;
        int resultPrize = 3;

        assertThat(input.checkWin(prize, bonusNumber))
                .isEqualTo(resultPrize);
    }

    @Test
    void 로또_당첨_검증_4등() {
        Lotto input = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto prize = new Lotto(List.of(1, 2, 3, 4, 12, 11));
        int bonusNumber = 45;
        int resultPrize = 4;

        assertThat(input.checkWin(prize, bonusNumber))
                .isEqualTo(resultPrize);
    }

    @Test
    void 로또_당첨_검증_5등() {
        Lotto input = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto prize = new Lotto(List.of(1, 13, 11, 4, 5, 12));
        int bonusNumber = 45;
        int resultPrize = 5;

        assertThat(input.checkWin(prize, bonusNumber))
                .isEqualTo(resultPrize);
    }

    @Test
    void 로또_낙첨_2개() {
        Lotto input = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto prize = new Lotto(List.of(11, 2, 13, 4, 15, 16));
        int bonusNumber = 45;
        int resultPrize = 0;

        assertThat(input.checkWin(prize, bonusNumber))
                .isEqualTo(resultPrize);
    }

    @Test
    void 로또_낙첨_1개() {
        Lotto input = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto prize = new Lotto(List.of(35, 23, 25, 31, 9, 6));
        int bonusNumber = 45;
        int resultPrize = 0;

        assertThat(input.checkWin(prize, bonusNumber))
                .isEqualTo(resultPrize);
    }

    @Test
    void 로또_낙첨_0개() {
        Lotto input = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto prize = new Lotto(List.of(9, 10, 20, 30, 40, 45));
        int bonusNumber = 45;
        int resultPrize = 0;

        assertThat(input.checkWin(prize, bonusNumber))
                .isEqualTo(resultPrize);
    }

}