package lotto;

import lotto.domain.RewardCalculator;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RwdCalcTest {
    private RewardCalculator calc;
    private List<Lotto> lottos = new ArrayList<>();

//    @BeforeEach
//    void setUp() {
//    }

    @Test
    void countNumOfMatchTest() {
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        calc = new RewardCalculator(lottos);

        List<Integer> lotto_A = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lotto_B = List.of(1, 2, 3, 4, 5, 7);
        List<Integer> lotto_C = List.of(1, 2, 4, 6, 9, 43);

        assertThat(calc.countNumOfMatches(lotto_A, lotto_B)).isEqualTo(5);
        assertThat(calc.countNumOfMatches(lotto_A, lotto_C)).isEqualTo(4);
    }

    @Test
    void calculateWinCountTest() {
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 6, 8)));
        WinningLotto.setWinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        calc = new RewardCalculator(lottos);
        calc.getResults();

        assertThat(calc.getWinCount()).isEqualTo(List.of(1, 1, 1, 0, 0, 0));
    }
}
