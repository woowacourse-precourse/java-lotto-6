package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.fixture.GameManagerFixture.총_2장_중_당첨_X_게임;
import static lotto.fixture.GameManagerFixture.총_3장_중_1등_로또_1장_게임;
import static org.assertj.core.api.Assertions.assertThat;

class GameManagerTest {
    @DisplayName("사용자의 수익률을 반환한다.")
    @Test
    public void getProfitRate() throws Exception {
        final GameManager gameManager = 총_2장_중_당첨_X_게임.생성();
        final double actual = gameManager.getProfitRate();
        final double expect = 0.;

        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("순위로 당첨 된 로또 개수를 조회한다.")
    @Test
    public void getMatchedCountFromRank() throws Exception {
        final GameManager gameManager = 총_3장_중_1등_로또_1장_게임.생성();
        final int expect = 1;
        final int actual = gameManager.getCountFromRank(1);

        assertThat(actual).isEqualTo(expect);
    }
}