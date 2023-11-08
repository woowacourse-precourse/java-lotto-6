package lotto;

import lotto.domain.GameResult;
import lotto.domain.GameService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameServiceTest {
    @DisplayName("손해볼 때의 수익률 계산 테스트")
    @Test
    void negativeRevenue() {
        for (GameResult result : GameResult.values()) {
            result.clearResultCount();
        }
        GameService gameService = new GameService();
        gameService.setPurchaseAmount(8000);

        GameResult.FIFTH_PRIZE.increaseResultCount();
        double testRevenue = gameService.getRevenue();

        assertThat(testRevenue).isEqualTo(62.5);
    }

    @DisplayName("이득볼 때의 수익률 계산 테스트")
    @Test
    void positiveRevenue() {
        for (GameResult result : GameResult.values()) {
            result.clearResultCount();
        }
        GameService gameService = new GameService();
        gameService.setPurchaseAmount(8000);

        GameResult.FOURTH_PRIZE.increaseResultCount();
        double testRevenue = gameService.getRevenue();

        assertThat(testRevenue).isEqualTo(625);
    }
}
