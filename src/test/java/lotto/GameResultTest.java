package lotto;

import lotto.model.GameResult;
import lotto.model.WinnerPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {
    @DisplayName("초기에는 모든 WinnerPrize 에 대해 0 값을 갖는다.")
    @Test
    void createMapWithWinnerPrize() {

        GameResult.create();
        Map<WinnerPrize, Integer> gameResult = GameResult.getGameResult();
        WinnerPrize[] allWinnerPrize = WinnerPrize.getAllWinnerPrize();

        gameResult.forEach(
                (winnerPrize, count) -> {
                    assertThat(allWinnerPrize).contains(winnerPrize);
                    assertThat(count).isEqualTo(0);

                }
        );
    }

    @DisplayName("해당 winnerPrize 에 대한 개수를 1 늘린다.")
    @Test
    void increaseCountOfWinnerPrize() {

        GameResult.create();

        GameResult.increaseWinnerPrizeCount(WinnerPrize.THREE_CORRECT);
        Map<WinnerPrize, Integer> gameResult = GameResult.getGameResult();
        Integer count = gameResult.get(WinnerPrize.THREE_CORRECT);

        assertThat(count).isEqualTo(1);
    }

    @DisplayName("당첨 금액을 구매 금액으로 나누어 수익률을 계산한다.")
    @Test
    void calculateProfitRate() {

        GameResult.create();
        GameResult.increaseWinnerPrizeCount(WinnerPrize.THREE_CORRECT);

        double profitRate = GameResult.calculateProfit(8000);

        assertThat(profitRate).isEqualTo(62.5);
    }
}
