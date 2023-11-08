package lotto.domain;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class YieldTest {

    @DisplayName("정상적으로 money를 생성한다.")
    @Test
    void createValidYield() {
        // given
        Money purchaseMoney = new Money(8000);
        Money reward = new Money(5000);

        // when
        ThrowableAssert.ThrowingCallable actual = () -> new Yield(purchaseMoney, reward);

        // then
        assertThatCode(actual).doesNotThrowAnyException();
    }

    @DisplayName("정상적으로 수익률을 계산한다.")
    @Test
    void calculateYieldTest() {
        // given
        Money purchaseMoney = new Money(8000);
        Money reward = new Money(5000);

        // when
        Yield yield = new Yield(purchaseMoney, reward);

        // then
        assertThat(yield.toString()).isEqualTo("62.5%");
    }
}
