package lotto.domain.model;

import lotto.domain.constant.DomainException;
import lotto.domain.model.Money;
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

    @Test
    void 구입금액이_1000으로_나누어_떨어지지_안으면_예외가_던져진다() {
        assertThatThrownBy(() -> new Money(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DomainException.ERROR.getMessage());
    }

    @Test
    void 천원단위의_구입금액인_경우_예외가_던져지지_않는다() {
        assertDoesNotThrow(() -> new Money(50000));
    }
}