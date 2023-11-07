package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @DisplayName("로또 결과를 확인한다.")
    @Test
    void confirmResult() {

        List<Lotto> lotto = new ArrayList<>(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(2, 3, 4, 5, 6, 7)),
                new Lotto(List.of(3, 4, 5, 6, 7, 8)),
                new Lotto(List.of(4, 5, 6, 7, 8, 9))));
        Lottos lottos = new Lottos(lotto);
        Lotto winningNumberLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 7;


        Map<Rank, Integer> result = lottos.calculateResult(
                new WinnerLotto(winningNumberLotto, bonus));


        assertThat(result.get(Rank.FIRST)).isEqualTo(1);
        assertThat(result.get(Rank.SECOND)).isEqualTo(1);
        assertThat(result.get(Rank.THIRD)).isEqualTo(0);
        assertThat(result.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(result.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(result.get(Rank.NONE)).isEqualTo(0);
    }
}
