package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.model.MoneyToBuy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyToBuyTest {

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
}
