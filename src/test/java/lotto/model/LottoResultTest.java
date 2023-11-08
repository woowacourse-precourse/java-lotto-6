package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    @DisplayName("2등 계산이 올바르게 되는지 테스트한다.")
    @Test
    void calcurateRank() {
        //given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Lottos lottos = new Lottos(List.of(lotto));
        WinningNumber winningNumber = new WinningNumber(List.of(1,2,3,4,5,20));
        BonusNumber bonusNumber = new BonusNumber(6, winningNumber);
        LottoResult lottoResult = new LottoResult(winningNumber, lottos, bonusNumber);

        //when
        lottoResult.calcurateLottoRank();
        int result = lottoResult.getRank().getSecondPlace();

        //then
        assertThat(result).isEqualTo(1);
    }
}