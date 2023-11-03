package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CustomerTest {
    @DisplayName("숫자를 입력하지 않으면 예외가 발생한다.")
    @Test
    void createCustomerByNotNumber() {
        assertThatThrownBy(() -> new Customer("테스트!"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자를 입력해주세요.");
    }
}