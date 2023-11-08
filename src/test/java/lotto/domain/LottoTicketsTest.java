package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

    @DisplayName("로또 당첨 등수를 반환한다.")
    @Test
    void compareAndGetLottoPrizeRanking() {
        WinningLotto winningLotto = WinningLotto.of(Lotto.of(List.of(3, 4, 5, 6, 7, 8)), BonusBall.valueOf(13));
        LottoTickets lottoTickets = LottoTickets.of(List.of(Lotto.of(List.of(1, 2, 3, 4, 5, 6))));

        List<LottoPrize> lottoPrizes = lottoTickets.getLottoPrizes(winningLotto);

        assertTrue(lottoPrizes.contains(LottoPrize.FORTH_PRIZE));
    }

    @DisplayName("로또갯수로 로또 구매 금액을 반환한다.")
    @Test
    void totalPurchasedAmount() {
        LottoTickets lottoTickets = LottoTickets.of(List.of(Lotto.of(List.of(1, 2, 3, 4, 5, 6))));

        assertThat(BigDecimal.valueOf(1000)).isEqualTo(lottoTickets.totalPurchasedAmount());
    }

}