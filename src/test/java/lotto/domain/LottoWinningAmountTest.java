package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoWinningAmountTest {

    @Test
    void 로또_당첨_기준이_없을_경우_예외가_발생한다() {
        assertThatThrownBy(() -> LottoWinningAmount.of(0, false))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_3개_일치시_상금을_반환한다() {
        assertEquals(LottoWinningAmount.of(3, false).getValue(), 5_000);
        assertEquals(LottoWinningAmount.of(3, true).getValue(), 5_000);
    }

    @Test
    void 로또_번호_4개_일치시_상금을_반환한다() {
        assertEquals(LottoWinningAmount.of(4, false).getValue(), 50_000);
        assertEquals(LottoWinningAmount.of(4, true).getValue(), 50_000);
    }

    @Test
    void 로또_번호_5개_일치_보너스_미일치시_상금을_반환한다() {
        assertEquals(LottoWinningAmount.of(5, false).getValue(), 1_500_000);
    }

    @Test
    void 로또_번호_5개_보너스_일치시_상금을_반환한다() {
        assertEquals(LottoWinningAmount.of(5, true).getValue(), 30_000_000);
    }

    @Test
    void 로또_번호_6개_일치시_상금을_반환한다() {
        assertEquals(LottoWinningAmount.of(6, false).getValue(), 2_000_000_000);
        assertEquals(LottoWinningAmount.of(6, true).getValue(), 2_000_000_000);
    }
}
