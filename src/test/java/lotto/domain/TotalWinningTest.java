package lotto.domain;

import lotto.enums.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TotalWinningTest {
    private TotalWinning totalWinning;

    @BeforeEach
    @Test
    void createTotalWinning() {
        assertRandomUniqueNumbersInRangeTest(() -> {
                    LottoPurchase lottoPurchase = new LottoPurchase(8000);
                    LottoTickets lottoTickets = new LottoTickets(8);
                    WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new LottoNumber(7));
                    WinningResult winningResult = new WinningResult(lottoTickets, winningLotto);
                    totalWinning = new TotalWinning(lottoPurchase, winningResult);
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
        assertThat(totalWinning.getTotalReturn()).isEqualTo(62.5);
    }
}