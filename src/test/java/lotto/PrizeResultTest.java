package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Prize;
import lotto.domain.PrizeResult;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeResultTest {
    PrizeResult prizeResult;

    @BeforeEach
    void initPrizeResult() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2));
        WinningLotto winningLotto = WinningLotto.of("1,2,3,4,5,7", "8");
        prizeResult = new PrizeResult(lottos, winningLotto);
    }

    @DisplayName("결과 계산 테스트")
    @Test
    void calculatePrizeTest() {
        assertThat(prizeResult.getResult().get(Prize.FIRST)).isEqualTo(0);
        assertThat(prizeResult.getResult().get(Prize.SECOND)).isEqualTo(0);
        assertThat(prizeResult.getResult().get(Prize.THIRD)).isEqualTo(1);
        assertThat(prizeResult.getResult().get(Prize.FOURTH)).isEqualTo(0);
        assertThat(prizeResult.getResult().get(Prize.FIFTH)).isEqualTo(0);
        assertThat(prizeResult.getResult().get(Prize.MISS)).isEqualTo(1);
    }

    @DisplayName("총 상금 계산 테스트")
    @Test
    void getPrizeMoneyTest() {
        assertThat(prizeResult.getPrizeMoney()).isEqualTo(1500000);
    }
}
