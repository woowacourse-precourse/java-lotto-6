package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {
    @Test
    @DisplayName("구입 금액이 1000원 단위가 아니면 에러처리")
    void 구입금액이_1000원_단위가_아니면_에러() throws Exception {
        //given
        int amount = 3432;

        //when
        //구입 금액을 생성하려고 시도하면

        //then
        assertThatThrownBy(() -> new PurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("")
    void 구입금액_0원_이상이_아닐시_에러() throws Exception {
        //given
        int amount = -120;

        //when
        //구입 금액을 생성하려고 시도하면

        //then
        assertThatThrownBy(() -> new PurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}