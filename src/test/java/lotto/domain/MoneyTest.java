package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void 구입금액이_0이라면_예외가_던져진다() {
        assertThatThrownBy(() -> new Money(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DomainException.ERROR.getMessage());
    }

    @Test
    void 구입금액이_음수라면_예외가_던져진다() {
        assertThatThrownBy(() -> new Money(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DomainException.ERROR.getMessage());
    }
}