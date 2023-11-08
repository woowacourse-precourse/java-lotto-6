package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;

import lotto.mock.MockNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitTest {
    LottoTicket lottoTicket;

    @BeforeEach
    void init() {
        NumberGenerator mockNumberGenerator = new MockNumberGenerator();
        PurchasePrice purchasePrice = PurchasePrice.from("1000");
        lottoTicket = LottoTicket.of(purchasePrice, mockNumberGenerator);
    }

    @DisplayName("1000원 투자, 5등 당첨 수익률 테스트")
    @Test
    void getFifthPlaceRateOfReturn() {
        // given
        WinningNumber winningNumber = WinningNumber.from("1,2,3,10,11,12");
        BonusNumber bonusNumber = BonusNumber.ofNotDuplicatedWithWinningNumber("40", winningNumber);
        Lottery lottery = new Lottery(winningNumber, bonusNumber, lottoTicket);
        LottoResult lottoResult = lottery.createLottoResult();
        Profit profit = new Profit(lottoResult);

        // when
        double rateOfReturn = profit.getRateOfReturn();
        double expectedRateOfReturn = 500.0;

        // then
        assertThat(rateOfReturn).isEqualTo(expectedRateOfReturn);
    }

    @DisplayName("1000원 투자, 1등 당첨 수익률 테스트")
    @Test
    void getFirstPlaceRateOfReturn() {
        // given
        WinningNumber winningNumber = WinningNumber.from("1,2,3,4,5,6");
        BonusNumber bonusNumber = BonusNumber.ofNotDuplicatedWithWinningNumber("40", winningNumber);
        Lottery lottery = new Lottery(winningNumber, bonusNumber, lottoTicket);
        LottoResult lottoResult = lottery.createLottoResult();
        Profit profit = new Profit(lottoResult);

        // when
        double rateOfReturn = profit.getRateOfReturn();
        double expectedRateOfReturn = 200_000_000.0;

        // then
        assertThat(rateOfReturn).isEqualTo(expectedRateOfReturn);
    }
}