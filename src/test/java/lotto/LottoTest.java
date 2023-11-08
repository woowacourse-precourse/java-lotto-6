package lotto;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;


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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호는 정렬되어야 한다.")
    @Test
    void createLottoWithSort() {
        Lotto lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("숫자의 범위는 1~45이여야 한다")
    @Test
    void createNumbersOutOfRange() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 55),1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 6개 일치 (1등)")
    @Test
    void createFirstWinningLottoNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winning = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 9;
        WinningLotto winningLotto = new WinningLotto(winning, bonus);

        assertThat(lotto.compare(winningLotto)).isEqualTo(Rank.FIRST);
    }


    @DisplayName("로또 번호 5개 일치 및 보너스 번호 일치 (2등)")
    @Test
    void createSecondWinningLottoNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winning = List.of(1, 2, 3, 4, 5, 7);
        int bonus = 6;
        WinningLotto winningLotto = new WinningLotto(winning, bonus);

        assertThat(lotto.compare(winningLotto)).isEqualTo(Rank.SECOND);
    }


    @DisplayName("로또 번호 5개 일치 (3등)")
    @Test
    void createThridWinningLottoNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winning = List.of(1, 2, 3, 4, 5, 7);
        int bonus = 8;
        WinningLotto winningLotto = new WinningLotto(winning, bonus);

        assertThat(lotto.compare(winningLotto)).isEqualTo(Rank.THIRD);
    }


}