package lotto.lotto;

import static lotto.global.Constant.LOTTO_NO_WIN_RANK;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    @DisplayName("잘못된 Rank가 입력된 경우 예외가 발생한다.")
    @Test
    void checkWrongRank() {
        assertThatThrownBy(() -> new LottoResult(LOTTO_NO_WIN_RANK.getNumber() - 1))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("1등의 상금이 20억이다.")
    @Test
    void checkFirstRankPrize() {
        LottoResult lottoResult = new LottoResult(1);
        assertThat(lottoResult.getRank()).isEqualTo(1);
        assertThat(lottoResult.getPrize()).isEqualTo(2000000000L);
    }

    @DisplayName("2등의 상금이 3000만원이다.")
    @Test
    void checkSecondRankPrize() {
        LottoResult lottoResult = new LottoResult(2);
        assertThat(lottoResult.getRank()).isEqualTo(2);
        assertThat(lottoResult.getPrize()).isEqualTo(30000000L);
    }

    @DisplayName("3등의 상금이 150만원이다.")
    @Test
    void checkThirdRankPrize() {
        LottoResult lottoResult = new LottoResult(3);
        assertThat(lottoResult.getRank()).isEqualTo(3);
        assertThat(lottoResult.getPrize()).isEqualTo(1500000L);
    }

    @DisplayName("4등의 상금이 5만원이다.")
    @Test
    void checkFourthRankPrize() {
        LottoResult lottoResult = new LottoResult(4);
        assertThat(lottoResult.getRank()).isEqualTo(4);
        assertThat(lottoResult.getPrize()).isEqualTo(50000L);
    }

    @DisplayName("5등의 상금이 5천원이다.")
    @Test
    void checkFifthRankPrize() {
        LottoResult lottoResult = new LottoResult(5);
        assertThat(lottoResult.getRank()).isEqualTo(5);
        assertThat(lottoResult.getPrize()).isEqualTo(5000L);
    }

    @DisplayName("당첨되지 않은 로또는 상금이 0원이다.")
    @Test
    void checkNoneRankPrize() {
        LottoResult lottoResult = new LottoResult(0);
        assertThat(lottoResult.getRank()).isEqualTo(0);
        assertThat(lottoResult.getPrize()).isEqualTo(0L);
    }
}