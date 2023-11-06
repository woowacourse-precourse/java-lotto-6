package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMatchCountTest {
    LottoMatchCount lottoMatchCount = new LottoMatchCount();

    @DisplayName("당첨 번호와 보너스 번호의 개수가 초기화되었는지 확인한다.")
    @Test
    void resetWinningNumberBonusNumberCount() {
        lottoMatchCount.plusWinningMatchCount();
        lottoMatchCount.plusBonusMatchCount();
        lottoMatchCount.resetCount();

        Assertions.assertThat(0).isEqualTo(lottoMatchCount.getWinningNumberMatch());
        Assertions.assertThat(0).isEqualTo(lottoMatchCount.getBonusNumberMatch());
    }

    @DisplayName("당첨 번호의 개수가 증가했는지 확인한다.")
    @Test
    void plusWinningMatchCount() {
        lottoMatchCount.plusWinningMatchCount();
        lottoMatchCount.plusWinningMatchCount();

        Assertions.assertThat(2).isEqualTo(lottoMatchCount.getWinningNumberMatch());
    }

    @DisplayName("보너스 번호의 개수가 증가했는지 확인한다.")
    @Test
    void plusBonusMatchCount() {
        lottoMatchCount.plusBonusMatchCount();
        lottoMatchCount.plusBonusMatchCount();

        Assertions.assertThat(2).isEqualTo(lottoMatchCount.getBonusNumberMatch());
    }
}
