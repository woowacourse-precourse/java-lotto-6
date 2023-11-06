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
    Lottos lottos;

    @BeforeEach
    void initLottos() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(6,7,8,9,10,11));
        this.lottos = Lottos.createByInput(List.of(lotto1, lotto2));
    }

    @DisplayName("3개가 일치하는 경우 테스트")
    @Test
    void fifthTest() {
        WinningLotto winningLotto = WinningLotto.of("1,2,3,30,31,32", "33");

        PrizeResult prizeResult = PrizeResult.of(lottos, winningLotto);

        assertThat(prizeResult.getPrizeCounts().get(Prize.FIRST)).isEqualTo(0);
        assertThat(prizeResult.getPrizeCounts().get(Prize.SECOND)).isEqualTo(0);
        assertThat(prizeResult.getPrizeCounts().get(Prize.THIRD)).isEqualTo(0);
        assertThat(prizeResult.getPrizeCounts().get(Prize.FOURTH)).isEqualTo(0);
        assertThat(prizeResult.getPrizeCounts().get(Prize.FIFTH)).isEqualTo(1);

        assertThat(prizeResult.getPrizeMoney()).isEqualTo(5000);
    }

    @DisplayName("4개가 일치하는 경우 테스트")
    @Test
    void fourthTest() {
        WinningLotto winningLotto = WinningLotto.of("1,2,3,4,30,31", "32");

        PrizeResult prizeResult = PrizeResult.of(lottos, winningLotto);

        assertThat(prizeResult.getPrizeCounts().get(Prize.FIRST)).isEqualTo(0);
        assertThat(prizeResult.getPrizeCounts().get(Prize.SECOND)).isEqualTo(0);
        assertThat(prizeResult.getPrizeCounts().get(Prize.THIRD)).isEqualTo(0);
        assertThat(prizeResult.getPrizeCounts().get(Prize.FOURTH)).isEqualTo(1);
        assertThat(prizeResult.getPrizeCounts().get(Prize.FIFTH)).isEqualTo(0);

        assertThat(prizeResult.getPrizeMoney()).isEqualTo(50000);
    }

    @DisplayName("5개가 일치하는 경우 테스트")
    @Test
    void thirdTest() {
        WinningLotto winningLotto = WinningLotto.of("1,2,3,4,5,30", "31");

        PrizeResult prizeResult = PrizeResult.of(lottos, winningLotto);

        assertThat(prizeResult.getPrizeCounts().get(Prize.FIRST)).isEqualTo(0);
        assertThat(prizeResult.getPrizeCounts().get(Prize.SECOND)).isEqualTo(0);
        assertThat(prizeResult.getPrizeCounts().get(Prize.THIRD)).isEqualTo(1);
        assertThat(prizeResult.getPrizeCounts().get(Prize.FOURTH)).isEqualTo(0);
        assertThat(prizeResult.getPrizeCounts().get(Prize.FIFTH)).isEqualTo(0);

        assertThat(prizeResult.getPrizeMoney()).isEqualTo(1500000);
    }

    @DisplayName("5개가 일치하고 보너스 볼까지 일치하는 경우 테스트")
    @Test
    void secondTest() {
        WinningLotto winningLotto = WinningLotto.of("1,2,3,4,5,30", "6");

        PrizeResult prizeResult = PrizeResult.of(lottos, winningLotto);

        assertThat(prizeResult.getPrizeCounts().get(Prize.FIRST)).isEqualTo(0);
        assertThat(prizeResult.getPrizeCounts().get(Prize.SECOND)).isEqualTo(1);
        assertThat(prizeResult.getPrizeCounts().get(Prize.THIRD)).isEqualTo(0);
        assertThat(prizeResult.getPrizeCounts().get(Prize.FOURTH)).isEqualTo(0);
        assertThat(prizeResult.getPrizeCounts().get(Prize.FIFTH)).isEqualTo(0);

        assertThat(prizeResult.getPrizeMoney()).isEqualTo(30000000);
    }

    @DisplayName("6개가 일치하는 경우 테스트")
    @Test
    void firstTest() {
        WinningLotto winningLotto = WinningLotto.of("1,2,3,4,5,6", "30");

        PrizeResult prizeResult = PrizeResult.of(lottos, winningLotto);

        assertThat(prizeResult.getPrizeCounts().get(Prize.FIRST)).isEqualTo(1);
        assertThat(prizeResult.getPrizeCounts().get(Prize.SECOND)).isEqualTo(0);
        assertThat(prizeResult.getPrizeCounts().get(Prize.THIRD)).isEqualTo(0);
        assertThat(prizeResult.getPrizeCounts().get(Prize.FOURTH)).isEqualTo(0);
        assertThat(prizeResult.getPrizeCounts().get(Prize.FIFTH)).isEqualTo(0);

        assertThat(prizeResult.getPrizeMoney()).isEqualTo(2000000000);
    }

    @DisplayName("여러 개의 상을 받은 경우 상금 계산 테스트")
    @Test
    void prizeMoneyTest() {
        WinningLotto winningLotto = WinningLotto.of("1,2,3,7,8,9", "30");

        PrizeResult prizeResult = PrizeResult.of(lottos, winningLotto);

        assertThat(prizeResult.getPrizeCounts().get(Prize.FIRST)).isEqualTo(0);
        assertThat(prizeResult.getPrizeCounts().get(Prize.SECOND)).isEqualTo(0);
        assertThat(prizeResult.getPrizeCounts().get(Prize.THIRD)).isEqualTo(0);
        assertThat(prizeResult.getPrizeCounts().get(Prize.FOURTH)).isEqualTo(0);
        assertThat(prizeResult.getPrizeCounts().get(Prize.FIFTH)).isEqualTo(2);

        assertThat(prizeResult.getPrizeMoney()).isEqualTo(10000);
    }
}
