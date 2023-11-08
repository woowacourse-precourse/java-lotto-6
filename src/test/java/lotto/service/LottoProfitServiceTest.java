package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.LottoProfit;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoWinningNumbers;
import lotto.domain.Lottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoProfitServiceTest {

    private LottoPrize lottoPrize;

    @BeforeEach
    void initLottoPrize() {
        lottoPrize = LottoPrize.create();

        int bonusNumber = 16;
        List<Integer> winningNumbers = List.of(1, 2, 3, 7, 11, 12);
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.create(winningNumbers, bonusNumber);
        Lottos lottos = new Lottos();

        lottos.save(Lotto.create(List.of(1, 2, 3, 7, 11, 12)));
        lottoPrize.countPrizeRank(lottos, lottoWinningNumbers);
    }

    @Test
    @DisplayName("createLottoProfit을 통해 총 수익률이 잘 나오는지 검증하는 테스트")
    void testCreateLottoProfit() {
        int purchaseCount = 8;
        LottoPurchase lottoPurchase = LottoPurchase.create(purchaseCount);
        LottoProfitService lottoProfitService = new LottoProfitService();

        LottoProfit lottoProfit = lottoProfitService.createLottoProfit(lottoPrize, lottoPurchase);
        double profitRate = lottoProfit.getTotalProfitRate().getProfitRate();

        assertThat(profitRate).isEqualTo(25000000.0);
    }
}