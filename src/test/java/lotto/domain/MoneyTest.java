package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    Money money;

    @BeforeEach
    void setUp() {
        money = new Money(1000);
    }

    @Test
    @DisplayName("money를 반환한다.")
    void getMoneyTest() {
        //given

        //when
        int temp = money.getMoney();

        //then
        assertThat(temp).isEqualTo(1000);
    }

    @Test
    @DisplayName("money 나누기 1000원 한 값을 quantity로 반환한다.")
    void getQuantityTest() {
        //given

        //when
        int quantity = money.getQuantity();

        //then
        assertThat(quantity).isEqualTo(1);
    }
}
