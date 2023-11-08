package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottoMoneyTest {

    @Test
    void 구입금액이_천원_단위가_아니다() {
        assertThatThrownBy(() -> new LottoMoney(10440))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입금액이_2백만원을_넘어간다() {
        assertThatThrownBy(() -> new LottoMoney(104400000))
                .isInstanceOf(IllegalArgumentException.class);
    }
}