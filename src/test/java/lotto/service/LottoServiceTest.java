package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.Prize;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoServiceTest {
    private LottoService lottoService = new LottoService();

    @Test
    @DisplayName("수익률 계산 테스트")
    void 수익률_계산_로직_테스트() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(1000);
        float revenue = 50000f;
        float earningRate = lottoService.getEarningRate(purchaseAmount, revenue);

        Assertions.assertThat(earningRate).isEqualTo(5000f);
    }

    @ParameterizedTest
    @CsvSource({"1000,1", "5000,5", "10000,10"})
    void 로또_구매_개수_테스트(int number, int amount) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(number);
        int lottoCount = lottoService.getLottoCount(purchaseAmount);

        Assertions.assertThat(lottoCount).isEqualTo(amount);
    }

    @Test
    @DisplayName("로또 결과로부터 수익률을 계산하는 서비스 로직을 테스트한다.")
    void 로또_결과로부터_수익금_계산하는_로직_테스트() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.add(3);
        float winningMoney = Prize.THIRD.getPrize();
        float revenue = lottoService.getRevenue(lottoResult);
        System.out.println(winningMoney);
        System.out.println(revenue);

        Assertions.assertThat(revenue).isEqualTo(winningMoney);
    }

    @Test
    @DisplayName("로또 결과를 계산하는 로직 테스트")
    void 로또_당첨_계산_로직_테스트_4_5등_당첨() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 10, 11)));
        lottos.add(new Lotto(List.of(1, 2, 3, 9, 10, 11)));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(45, winningNumbers);

        LottoResult lottoResult = lottoService.getLottoResult(lottos, winningNumbers, bonusNumber);
        float revenue = lottoService.getRevenue(lottoResult);

        Assertions.assertThat(revenue).isEqualTo(55000f);
    }

    @Test
    @DisplayName("로또 결과를 계산하는 로직 테스트")
    void 로또_당첨_계산_로직_테스트_2등_당첨() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 7));
        BonusNumber bonusNumber = new BonusNumber(8, winningNumbers);

        LottoResult lottoResult = lottoService.getLottoResult(lottos, winningNumbers, bonusNumber);
        float revenue = lottoService.getRevenue(lottoResult);

        Assertions.assertThat(revenue).isEqualTo(30000000f);
    }
}