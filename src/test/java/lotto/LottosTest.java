package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottosTest {

    @DisplayName("당첨 로또를 전달했을 때 3개 일치하는 로또가 2개가 된다.")
    @Test
    void countWinningNumbersTest() {
        Lottos lottos = new Lottos();
        lottos.addLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.addLotto(new Lotto(List.of(8, 2, 3, 4, 10, 26)));
        lottos.addLotto(new Lotto(List.of(31, 32, 33, 34, 35, 36)));

        lottos.countWinningNumber(new Lotto(List.of(11, 2, 3, 4, 15, 16)));
        int threeWins = lottos.getThreeWins();

        Assertions.assertThat(threeWins).isEqualTo(2);
    }
}
