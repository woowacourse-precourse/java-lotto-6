package lotto;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import lotto.model.Customer;
import lotto.model.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @DisplayName("고객이 로또를 살 수 있습니다.")
    @Test
    void buyLotto() {
        // given
        Customer customer = new Customer();
        Money money = Money.createMoney("3000");
        // when

        // then
        assertDoesNotThrow(() -> customer.buyLotto(money));
    }
}
