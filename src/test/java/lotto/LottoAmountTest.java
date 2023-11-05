package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottoAmountTest {
    private static final String ONLY_DIVISIBLE_BY_THOUSAND = "[ERROR] 구입 금액은 1000원 단위로 입력해주세요.";
    @Test
    void 구입_금액이_1000원_단위가_아닌_경우() {
        assertThatThrownBy(() -> new LottoAmount(1001))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ONLY_DIVISIBLE_BY_THOUSAND);
    }

}
