package domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {

    Lottos lottos;
    WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        List<Lotto> lotto = new ArrayList<>();
        lotto.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lotto.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lotto.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        lotto.add(new Lotto(List.of(1, 2, 3, 4, 7, 8)));
        lotto.add(new Lotto(List.of(1, 2, 3, 7, 8, 9)));

        lottos = new Lottos(lotto);

        winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
    }

    @DisplayName("상금 계산 테스트")
    @Test
    void getRewardTest() {
        Result result = new Result(lottos, winningLotto);
        int getResult = result.getReward();

        assertThat(getResult).isEqualTo(2031555000);
    }
}
