package lotto.domain.customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CustomerTest {
    Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("5000");
    }

    @DisplayName("로또 구매 금액을 인자로 받아 customer 객체 생성")
    @Test
    void createCustomer() {
        assertThat(customer).isNotEqualTo(null);
    }

    @DisplayName("입력값이 숫자가 아니면 예외가 발생한다.")
    @Test
    void notNumber() {
        assertThatThrownBy(() -> new Customer("price"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 음수이면 예외가 발생한다.")
    @Test
    void negativeNumber() {
        assertThatThrownBy(() -> new Customer("-5000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void notMultipleThousand() {
        assertThatThrownBy(() -> new Customer("5500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매금액이 10만원을 초과하면 예외가 발생한다.")
    @Test
    void over100000() {
        assertThatThrownBy(() -> new Customer("300000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매금액으로 로또 구매 갯수를 알 수 있다.")
    @Test
    void getQuantityOfPurchase() {
        assertThat(customer.getQuantity()).isEqualTo(5);
    }

    @DisplayName("구매 갯수만큼 발행한 로또를 확인할 수 있다.")
    @Test
    void getLottos() {
        // test code 구현해야 함
    }
}