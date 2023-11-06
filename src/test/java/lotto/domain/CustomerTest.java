package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CustomerTest {
    @DisplayName("Customer생성 시 1000단위로 입력되지 않는경우 예외가 발생한다.")
    @Test
    void createCustomerUnitsOf1000() {
        assertThatThrownBy(() -> new Customer(1001))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Customer(999))
                .isInstanceOf(IllegalArgumentException.class);
    }
}