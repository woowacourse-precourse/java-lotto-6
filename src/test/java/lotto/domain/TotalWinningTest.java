package lotto.domain;

import lotto.enums.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class TotalWinningTest {
    private TotalWinning totalWinning;

    @BeforeEach
    @Test
    void createTotalWinning() {
        assertRandomUniqueNumbersInRangeTest(() -> {
                    LottoPurchase lottoPurchase = LottoPurchase.valueOf(8000);
                    LottoTickets lottoTickets = LottoTickets.createdByNumber(8);
                    WinningLotto winningLotto = WinningLotto.of(Lotto.valueOf(List.of(1, 2, 3, 4, 5, 6)), LottoNumber.valueOf(7));
                    WinningResult winningResult = WinningResult.compare(lottoTickets, winningLotto);
                    totalWinning = TotalWinning.compare(lottoPurchase, winningResult);
                },
                List.of(1, 2, 3, 23, 34, 35),
                List.of(1, 2, 7, 24, 35, 36),
                List.of(1, 2, 7, 24, 35, 37),
                List.of(1, 2, 7, 34, 45, 26),
                List.of(1, 2, 7, 14, 15, 16),
                List.of(1, 2, 7, 24, 25, 26),
                List.of(1, 2, 7, 34, 35, 36),
                List.of(1, 2, 7, 37, 25, 40)
        );
    }

    @Test
    void getTotalAmount() {
        assertThat(totalWinning.getTotalAmount()).isEqualTo(Rank.FIFTH.getWinningAmount());
    }

    @Test
    void getTotalReturn() {
        assertThat(totalWinning.getTotalReturn()).isEqualTo(0.625);
    }
}