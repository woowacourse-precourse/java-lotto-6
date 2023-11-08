package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.enums.Rank;
import lotto.mock.MockNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryTest {
    LottoTicket lottoTicket;

    @BeforeEach
    void init() {
        NumberGenerator mockNumberGenerator = new MockNumberGenerator();
        PurchasePrice purchasePrice = PurchasePrice.from("1000");
        lottoTicket = LottoTicket.of(purchasePrice, mockNumberGenerator);
    }

    @DisplayName("2등 당첨 시 당첨금 테스트")
    @Test
    void fivePlacePrizeTest() {
        // given
        WinningNumber winningNumber = WinningNumber.from("1,2,3,4,5,10");
        BonusNumber bonusNumber = BonusNumber.ofNotDuplicatedWithWinningNumber("6", winningNumber);
        Lottery lottery = new Lottery(winningNumber, bonusNumber, lottoTicket);
        LottoResult lottoResult = lottery.createLottoResult();

        // when
        int calculateTotalPrize = lottoResult.calculateTotalPrize();
        int expectedPrize = 30_000_000;

        // then
        assertThat(calculateTotalPrize).isEqualTo(expectedPrize);
    }

    @DisplayName("1등 당첨된 로또 수 테스트")
    @Test
    void firstPlaceMatchesLottoCountTest() {
        // given
        WinningNumber winningNumber = WinningNumber.from("1,2,3,4,5,6");
        BonusNumber bonusNumber = BonusNumber.ofNotDuplicatedWithWinningNumber("10", winningNumber);
        Lottery lottery = new Lottery(winningNumber, bonusNumber, lottoTicket);
        LottoResult lottoResult = lottery.createLottoResult();

        // when
        int matchCount = lottoResult.findMatchCountFor(Rank.FIRST_PLACE);
        int expectedCount = 1;

        // then
        assertThat(matchCount).isEqualTo(expectedCount);
    }
}