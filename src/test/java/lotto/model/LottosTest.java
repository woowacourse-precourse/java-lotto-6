package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosTest {

    @DisplayName("8000원 입력시 로또 8장 구매")
    @Test
    void buyMultipleAllRandom() {
        final Lottos lottos = new Lottos();

        lottos.buyMultipleAllRandom(8000);

        assertThat(lottos.getLottos().size()).isEqualTo(8);
    }

    @DisplayName("당첨 번호 설정")
    @Test
    void setGoal(){
        final List<Integer> goal = List.of(1,2,3,4,5,6);
        final Lottos lottos = new Lottos();

        lottos.setGoal(goal);

        assertThat(lottos.getGoal()).isEqualTo(goal);
    }

    @DisplayName("당첨 번호 설정 예외 (번호 중복)")
    @Test
    void setGoalFail(){
        final List<Integer> goal = List.of(1,2,3,4,5,5);
        final Lottos lottos = new Lottos();

        assertThatThrownBy(()->lottos.setGoal(goal))
                .isInstanceOf(IllegalArgumentException.class);
    }
}