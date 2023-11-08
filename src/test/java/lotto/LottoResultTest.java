package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {
    @DisplayName("각 등수별로 당첨 횟수를 기록한다.")
    @Test
    void recordRank_CorrectlyRecordsWinningCounts() {
        LottoResult lottoResult = new LottoResult();

        lottoResult.recordRank(LottoRank.FIRST);
        lottoResult.recordRank(LottoRank.THIRD);
        lottoResult.recordRank(LottoRank.THIRD);

        assertThat(lottoResult.getCountOfRank(LottoRank.FIRST)).isEqualTo(1);
        assertThat(lottoResult.getCountOfRank(LottoRank.THIRD)).isEqualTo(2);
        assertThat(lottoResult.getCountOfRank(LottoRank.SECOND)).isEqualTo(0);
    }

    @DisplayName("총 당첨 금액을 정확히 계산한다.")
    @Test
    void calculateTotalWinningAmount_CalculatesCorrectSum() {
        LottoResult lottoResult = new LottoResult();

        lottoResult.recordRank(LottoRank.FIRST); // 2,000,000,000
        lottoResult.recordRank(LottoRank.THIRD); // 1,500,000
        lottoResult.recordRank(LottoRank.FOURTH); // 50,000

        int totalWinningAmount = lottoResult.calculateTotalWinningAmount();
        assertThat(totalWinningAmount).isEqualTo(2_001_550_000);
    }

    @DisplayName("수익률을 정확히 계산한다.")
    @Test
    void calculateProfitRate_CalculatesCorrectRate() {
        LottoResult lottoResult = new LottoResult();
        int numberOfTickets = 10; // Assuming 10 tickets purchased

        lottoResult.recordRank(LottoRank.FIRST); // 2,000,000,000
        double profitRate = lottoResult.calculateProfitRate(numberOfTickets);

        assertThat(profitRate).isEqualTo(20000000.0);
    }

    @DisplayName("구입 티켓이 없을 때 수익률 계산 시 예외를 던진다.")
    @Test
    void calculateProfitRate_ThrowsExceptionWhenDivisionByZero() {
        LottoResult lottoResult = new LottoResult();

        assertThatThrownBy(() -> lottoResult.calculateProfitRate(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0이어서 수익률을 계산할 수 없습니다.");
    }
}
