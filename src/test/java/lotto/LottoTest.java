package lotto;

import lotto.model.Lotto;
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

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호가 6개 모두 일치하면 1등을 반환한다.")
    @Test
    void allMatchTest() {
        final Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Integer> goal = List.of(1,2,3,4,5,6);
        int bonus = 7;

        int rank = lotto.match(goal, bonus);

        assertThat(rank).isEqualTo(1);
    }
    @DisplayName("로또 번호 5개와 보너스번호가 일치하면 2등을 반환한다.")
    @Test
    void match5andBonusTest() {
        final Lotto lotto = new Lotto(List.of(1,2,3,4,5,7));
        List<Integer> goal = List.of(1,2,3,4,5,6);
        int bonus = 7;

        int rank = lotto.match(goal, bonus);

        assertThat(rank).isEqualTo(2);
    }
    @DisplayName("로또 번호 5개가 일치하면 3등을 반환한다.")
    @Test
    void match5Test() {
        final Lotto lotto = new Lotto(List.of(1,2,3,4,5,8));
        List<Integer> goal = List.of(1,2,3,4,5,6);
        int bonus = 7;

        int rank = lotto.match(goal, bonus);

        assertThat(rank).isEqualTo(3);
    }
}