package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    public void 입력한_금액이_1000원_단위가_아니면_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> new Money(1800))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 입력한_금액이_음수인_경우_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> new Money(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 입력한_금액이_0인_경우_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> new Money(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}