package lotto;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    @DisplayName("로또 번호의 개수가 6개가 안되면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 당첨 번호를 비교하여 당첨 갯수가 6개가 나와야 한다.")
    @Test
    void compareLottoWithWinnerLotto() {

        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto winner_lotto = new Lotto(List.of(1,2,3,4,5,6));

        assertThat(lotto.CompWinner(winner_lotto)).isEqualTo(6);

    }

    @DisplayName("로또 번호안에 해당 번호가 있는지 확인한다.")
    @Test
    void compareLottoWithBonus() {

        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        assertThat(lotto.ContainNumber(6)).isEqualTo(true);

    }


}