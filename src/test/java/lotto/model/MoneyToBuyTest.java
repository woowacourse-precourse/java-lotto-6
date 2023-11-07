package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyToBuyTest {

    // Error case
    @Test
    @DisplayName("금액이 0이하 에러 발생1")
    void createMoneyToBuyByUnderValue_1() {
        assertThatThrownBy(() -> new MoneyToBuy(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액이 0이하 에러 발생2")
    void createMoneyToBuyByUnderValue_2() {
        assertThatThrownBy(() -> new MoneyToBuy(-123))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액이 천원단위가 아니면 에러 발생1")
    void createMoneyToBuyByWrongValue_1() {
        assertThatThrownBy(() -> new MoneyToBuy(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액이 천원단위가 아니면 에러 발생2")
    void createMoneyToBuyByWrongValue_2() {
        assertThatThrownBy(() -> new MoneyToBuy(123))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // Normal case

    @Test
    @DisplayName("금액을 1000으로 나눈 값을 반환")
    void getLottosNumberTest() {
        MoneyToBuy moneyToBuy = new MoneyToBuy(12000);

        assertThat(moneyToBuy.getLottosNumber()).isEqualTo(12);
    }
}
