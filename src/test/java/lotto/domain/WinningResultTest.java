package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningResultTest {
    @DisplayName("당첨 결과에 등수를 추가한다.")
    @Test
    void addPrize() {
        WinningResult winningResult = new WinningResult();

        winningResult.addRank(Rank.FIFTH);

        assertThat(winningResult.getValues()).containsEntry(Rank.FIFTH, 1);
    }

    @DisplayName("당첨 개수에 따라 당첨 결과를 출력한다.")
    @Test
    void getFormattedStatistics() {
        WinningResult winningResult = new WinningResult();
        winningResult.addRank(Rank.FIRST);
        winningResult.addRank(Rank.FIFTH);

        String actual = winningResult.getFormattedStatistics();

        assertThat(actual).isEqualTo("""
            3개 일치 (5,000원) - 1개
            4개 일치 (50,000원) - 0개
            5개 일치 (1,500,000원) - 0개
            5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
            6개 일치 (2,000,000,000원) - 1개""");
    }

    @DisplayName("당첨 개수와 구입금액으로 수익률 결과를 출력한다.")
    @Test
    void getFormattedProfit() {
        Long money = 8_000L;
        WinningResult winningResult = new WinningResult();
        winningResult.addRank(Rank.FIFTH);

        String actual = winningResult.getFormattedProfit(money);

        assertThat(actual).isEqualTo("총 수익률은 62.5%입니다.");
    }
}
