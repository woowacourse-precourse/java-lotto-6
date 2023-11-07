package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @DisplayName("맞춘 번호 개수별 당첨 로또 개수를 확인한다.")
    @Test
    void 당첨_로또_판별() {
        //given
        Lottos lottos = new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(10, 2, 3, 4, 5, 6)),
                new Lotto(List.of(10, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 2, 3, 4, 5, 6)),
                new Lotto(List.of(10, 20, 3, 4, 5, 6)),
                new Lotto(List.of(10, 20, 30, 4, 5, 6)),
                new Lotto(List.of(10, 20, 30, 40, 5, 6))));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(7);

        //when
        HashMap<Integer, Integer> winnings = lottos.determineWinnings(winningLotto, bonus);

        //then
        assertThat(winnings).hasSize(5);
        assertThat(winnings.get(7)).isEqualTo(1);
        assertThat(winnings.get(6)).isEqualTo(1);
        assertThat(winnings.get(5)).isEqualTo(2);
        assertThat(winnings.get(4)).isEqualTo(1);
        assertThat(winnings.get(3)).isEqualTo(1);
        assertThat(winnings.containsKey(2)).isFalse();

    }

}
