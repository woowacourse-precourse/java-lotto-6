package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    @DisplayName("돈을 천원미만 투입하면 에러를 발생시켜야한다")
    void inputMinimumMoneyTest() {
        // when && then
        Assertions.assertThatThrownBy( () -> new Money(500))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy( () -> new Money(444))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("돈을 천원 단위로 투입안하면 에러를 발생시켜야한다")
    void inputUnitMoneyTest() {
        // when && then
        Assertions.assertThatThrownBy( () -> new Money(1500))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy( () -> new Money(4444))
                .isInstanceOf(IllegalArgumentException.class);
    }

}