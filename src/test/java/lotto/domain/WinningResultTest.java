package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class WinningResultTest {

    @Test
    void 로또번호_매치개수_테스트() {
        WinningResult winningResult = new WinningResult();
        int maxTestCount = 200;

        int testCount = 0;
        while (testCount != maxTestCount) {
            testCount++;
            winningResult.addThreeMatches();
            assertThat(winningResult.getThreeMatches()).isEqualTo(testCount);

            winningResult.addFourMatches();
            assertThat(winningResult.getFourMatches()).isEqualTo(testCount);

            winningResult.addFiveMatches();
            assertThat(winningResult.getFiveMatches()).isEqualTo(testCount);

            winningResult.addFiveAndBonusMatches();
            assertThat(winningResult.getFiveAndBonusMatches()).isEqualTo(testCount);

            winningResult.addSixMatches();
            assertThat(winningResult.getSixMatches()).isEqualTo(testCount);
        }
    }

    @Test
    void 총수익률_테스트() {
        int purchaseAmount = 8000;
        WinningResult winningResult = new WinningResult();
        winningResult.addThreeMatches();
        winningResult.calculateTotalReturn(purchaseAmount);

        assertThat(winningResult.getTotalReturn()).isEqualTo(62.5);
    }

}