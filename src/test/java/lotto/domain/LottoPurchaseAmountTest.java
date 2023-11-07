package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoPurchaseAmountTest {

    @Test
    void 로또_구입금액이_로또_한장_가격_보다_작으면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoPurchaseAmount.create(999))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_구입금액에서_잔돈이_남으면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoPurchaseAmount.create(1_001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_구입_개수를_반환한다() {
        assertEquals(LottoPurchaseAmount.create(8_000).getLottoCount(), new Count(8));
    }
}