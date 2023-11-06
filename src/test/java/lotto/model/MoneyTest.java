package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class MoneyTest {
    private static final String ERROR = "[ERROR]";

    @Test
    void 구입_금액이_숫자가_아닌_경우_예외_발생() {
        assertThatThrownBy(() -> new Money("가나다"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }

    @Test
    void 구입_금액이_1000원_단위가_아닌_경우_예외_발생() {
        assertThatThrownBy(() -> new Money("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }

    @Test
    void 구입_금액이_0원인_경우_예외_발생() {
        assertThatThrownBy(() -> new Money("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }
}