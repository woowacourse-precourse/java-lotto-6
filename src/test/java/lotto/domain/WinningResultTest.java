package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import lotto.domain.lotto.Bonus;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningResultTest {

    @DisplayName("총 상금을 계산한다")
    @Test
    void 상금_계산(){
        //given
        WinningResult winningResult = createLottosAndGetWinningResults();

        //when
        long prize = winningResult.getTotalLotteryPrize();

        //then
        assertThat(prize).isEqualTo(2033050000);
    }

    @DisplayName("각 등수별 당첨 개수를 반환한다.")
    @Test
    void 일등_계산(){
        //given
        WinningResult winningResult = createLottosAndGetWinningResults();

        //when
        int firstPrize = winningResult.getFirstPrizeCount();
        int secondPrize = winningResult.getSecondPrizeCount();
        int thirdPrize = winningResult.getThirdPrizeCount();
        int fourthPrize = winningResult.getFourthPrizeCount();
        int fifthPrize = winningResult.getFifthPrizeCount();

        //then
        assertThat(firstPrize).isEqualTo(1);
        assertThat(secondPrize).isEqualTo(1);
        assertThat(thirdPrize).isEqualTo(2);
        assertThat(fourthPrize).isEqualTo(1);
        assertThat(fifthPrize).isEqualTo(0);
    }

    private WinningResult createLottosAndGetWinningResults() {
        Lottos lottos = new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(10, 2, 3, 4, 5, 6)),
                new Lotto(List.of(10, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 2, 3, 4, 5, 6)),
                new Lotto(List.of(10, 20, 3, 4, 5, 6)),
                new Lotto(List.of(10, 20, 30, 40, 5, 6)),
                new Lotto(List.of(10, 20, 30, 40, 5, 6))));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(7);
        HashMap<Integer, Integer> winningsCount = lottos.determineWinningsCount(winningLotto, bonus);
        return new WinningResult(winningsCount);
    }

}
