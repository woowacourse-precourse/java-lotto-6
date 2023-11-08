package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoFactoryTest {
    private LottoFactory lottoFactory;

    @BeforeEach
    void setUp() {
        lottoFactory = new LottoFactory();
    }

    @DisplayName("사용자가 입력한 금액을 로또 금액으로 나눠서 구매 개수를 반환한다.")
    @Test
    void calculateNumberOfLottos() {
        //given
        int userPurchaseAmount = 2000;

        //when
        int numberOfLottos = lottoFactory.calculateNumberOfLottos(userPurchaseAmount);

        //then
        assertThat(numberOfLottos).isEqualTo(2);
    }

    @DisplayName("구매한 로또를 개수만큼 발급한다.")
    @Test
    void getPurchasedLottos() {
        //given
        int numberOfLottos = 2;

        //when
        List<Lotto> purchasedLottos = lottoFactory.getPurchasedLottos(numberOfLottos);

        //then
        assertThat(purchasedLottos.size()).isEqualTo(2);
    }

    @DisplayName("당첨 번호와 로또 번호를 비교해서 결과를 계산한다.")
    @Test
    void calculateResults_WithExpectedWinningResults() {
        //given
        int userPurchaseAmount = 8000;
        int expectedThirdPlaceWins = 3;
        int expectedFifthPlaceWins = 2;
        double expectedReturn = (3 * 1_500_000 + 2 * 5_000) / (double) userPurchaseAmount * 100;
        expectedReturn = Math.round(expectedReturn * 10.0) / 10.0;

        //when
        LottoResult lottoResult = new LottoResult();
        for (int i = 0; i < expectedThirdPlaceWins; i++) {
            lottoResult.addWin(WinningCriteria.THIRD_PLACE);
        }
        for (int i = 0; i < expectedFifthPlaceWins; i++) {
            lottoResult.addWin(WinningCriteria.FIFTH_PLACE);
        }

        //then
        double calculatedReturn = lottoResult.getRoundedReturn(userPurchaseAmount);
        assertThat(calculatedReturn).isEqualTo(expectedReturn);
    }
}