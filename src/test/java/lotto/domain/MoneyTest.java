package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    @DisplayName("money 나누기 1000원 한 값을 quantity로 반환한다")
    void getQuantityTest() {
        //given
        Money money = new Money(1000);

        //when
        int quantity = money.getQuantity();

        //then
        Assertions.assertThat(quantity).isEqualTo(1);
    }
}
