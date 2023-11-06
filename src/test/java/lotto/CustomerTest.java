package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import lotto.model.Customer;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.WinLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @DisplayName("고객이 로또를 살 수 있습니다.")
    @Test
    void buyLotto() {
        // given
        Customer customer = new Customer();
        Money money = new Money("3000");
        // when

        // then
        assertDoesNotThrow(() -> customer.buyLotto(money));
    }
}
