package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    private static final Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
    private static final Lottos lottos = new Lottos(List.of(lotto));
    private static final WinningNumber winningNumber = new WinningNumber(List.of(1,2,3,4,5,20));
    private static final BonusNumber bonusNumber = new BonusNumber(6, winningNumber);

    @DisplayName("2등 계산이 올바르게 되는지 테스트한다.")
    @Test
    void calculateRank() {
        //given
        LottoResult lottoResult = new LottoResult(winningNumber, lottos, bonusNumber);

        //when
        lottoResult.calcurateLottoRank();
        int result = lottoResult.getRank().getSecondPlace();

        //then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("수익률 계산이 올바르게 되는지 테스트한다")
    @Test
    void calulateRateOfReturn() {
        //given
        int purchaseAmount = 5000;
        LottoResult lottoResult = new LottoResult(winningNumber, lottos, bonusNumber);
        lottoResult.calcurateLottoRank();

        //when
        double result = lottoResult.caclurateReturnOfRate(purchaseAmount);

        //then
        assertThat(result).isEqualTo(600000);
    }
}