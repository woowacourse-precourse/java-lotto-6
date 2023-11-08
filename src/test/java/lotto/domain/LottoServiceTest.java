package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    void setUp(){
        LottoRepository lottoRepository = new LottoRepository();
        lottoService = new LottoService(lottoRepository);
    }

    @DisplayName("구매한 로또 개수를 저장하고 조회하는지 확인")
    @Test
    void saveAndFindPurchaseCountTest() {
        int purchaseAmount = 5000;
        lottoService.savePurchaseCount(purchaseAmount);

        int actualPurchaseCount = lottoService.findPurchaseCount();
        assertThat(actualPurchaseCount).isEqualTo(5);
    }

    @DisplayName("당첨 번호를 저장하고 조회하는지 확인")
    @Test
    void saveAndFindWinningLottoTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        lottoService.saveWinningLotto(numbers, bonusNumber);

        WinningLotto WinningLotto = lottoService.findWinningLotto();
        assertThat(numbers).isEqualTo(WinningLotto.getNumbers());
        assertThat(bonusNumber).isEqualTo(WinningLotto.getBonusNumber());
    }

    @DisplayName("로또를 입력 개수만큼 발급하는지 확인")
    @Test
    void issueLottosAndCreateWinningResultTest() {
        lottoService.issueLottos(5);

        Lottos actualLottos = lottoService.findAllLottos();
        assertThat(actualLottos.size()).isEqualTo(5);
    }

    @DisplayName("수익률을 계산하는지 확인")
    @Test
    void getReturnRateTest() {
        int purchaseCount = 5;
        lottoService.issueLottos(purchaseCount);

        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        lottoService.createWinningResult(lottoService.findAllLottos(), winningLotto);

        WinningResult winningResult = lottoService.findWinningResult();

        int totalPrize = winningResult.getFirstPlaceCount() * 2000000000 +
                winningResult.getSecondPlaceCount() * 30000000 +
                winningResult.getThirdPlaceCount() * 1500000 +
                winningResult.getFourthPlaceCount() * 50000 +
                winningResult.getFifthPlaceCount() * 5000;

        float expectedReturnRate = (float) totalPrize / (purchaseCount * 1000) * 100;
        float actualReturnRate = lottoService.getReturnRate(winningResult, purchaseCount * 1000);
        Assertions.assertEquals(expectedReturnRate, actualReturnRate);
    }

}
