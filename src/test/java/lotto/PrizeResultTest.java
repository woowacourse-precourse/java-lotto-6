package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
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
        Lotto lotto1 = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = Lotto.from(List.of(6, 7, 8, 9, 10, 11));
        this.lottos = Lottos.createByInput(List.of(lotto1, lotto2));
    }

    List<String> initAnswer(int fifth, int fourth, int third, int second, int first) {
        return List.of(
                String.format("%s - %d개", Prize.FIFTH.getPrint(), fifth),
                String.format("%s - %d개", Prize.FOURTH.getPrint(), fourth),
                String.format("%s - %d개", Prize.THIRD.getPrint(), third),
                String.format("%s - %d개", Prize.SECOND.getPrint(), second),
                String.format("%s - %d개", Prize.FIRST.getPrint(), first)
        );
    }

    @DisplayName("3개가 일치하는 경우 테스트")
    @Test
    void fifthTest() {
        WinningLotto winningLotto = WinningLotto.of("1,2,3,30,31,32", "33");
        List<String> answers = initAnswer(1,0,0,0,0);
        PrizeResult prizeResult = PrizeResult.of(lottos, winningLotto);

        assertThat(prizeResult.getResults()).isEqualTo(answers);
        assertThat(prizeResult.getPrizeMoney()).isEqualTo(5000);
    }

    @DisplayName("4개가 일치하는 경우 테스트")
    @Test
    void fourthTest() {
        WinningLotto winningLotto = WinningLotto.of("1,2,3,4,30,31", "32");
        List<String> answers = initAnswer(0,1,0,0,0);
        PrizeResult prizeResult = PrizeResult.of(lottos, winningLotto);

        assertThat(prizeResult.getResults()).isEqualTo(answers);
        assertThat(prizeResult.getPrizeMoney()).isEqualTo(50000);
    }

    @DisplayName("5개가 일치하는 경우 테스트")
    @Test
    void thirdTest() {
        WinningLotto winningLotto = WinningLotto.of("1,2,3,4,5,30", "31");
        List<String> answers = initAnswer(0,0,1,0,0);
        PrizeResult prizeResult = PrizeResult.of(lottos, winningLotto);

        assertThat(prizeResult.getResults()).isEqualTo(answers);
        assertThat(prizeResult.getPrizeMoney()).isEqualTo(1500000);
    }

    @DisplayName("5개가 일치하고 보너스 볼까지 일치하는 경우 테스트")
    @Test
    void secondTest() {
        WinningLotto winningLotto = WinningLotto.of("1,2,3,4,5,30", "6");
        List<String> answers = initAnswer(0,0,0,1,0);
        PrizeResult prizeResult = PrizeResult.of(lottos, winningLotto);

        assertThat(prizeResult.getResults()).isEqualTo(answers);
        assertThat(prizeResult.getPrizeMoney()).isEqualTo(30000000);
    }

    @DisplayName("6개가 일치하는 경우 테스트")
    @Test
    void firstTest() {
        WinningLotto winningLotto = WinningLotto.of("1,2,3,4,5,6", "30");
        List<String> answers = initAnswer(0,0,0,0,1);
        PrizeResult prizeResult = PrizeResult.of(lottos, winningLotto);

        assertThat(prizeResult.getResults()).isEqualTo(answers);
        assertThat(prizeResult.getPrizeMoney()).isEqualTo(2000000000);
    }

    @DisplayName("여러 개의 상을 받은 경우 상금 계산 테스트")
    @Test
    void prizeMoneyTest() {
        WinningLotto winningLotto = WinningLotto.of("1,2,3,7,8,9", "30");
        List<String> answers = initAnswer(2,0,0,0,0);
        PrizeResult prizeResult = PrizeResult.of(lottos, winningLotto);

        assertThat(prizeResult.getResults()).isEqualTo(answers);
        assertThat(prizeResult.getPrizeMoney()).isEqualTo(10000);
    }
}
