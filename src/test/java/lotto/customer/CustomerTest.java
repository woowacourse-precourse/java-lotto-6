package lotto.customer;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CustomerTest {

    @ParameterizedTest
    @CsvSource(value = {"0", "d123", "123d", "1000.", "!1000", "1000j"})
    @DisplayName("자연수가 아닌 값을 넣을 때 에러가 발생한다.")
    void 가격입력_숫자이외의값_입력(String containNotInteger) {
        assertThatThrownBy(() -> new Customer(containNotInteger))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 자연수 형태의 값을 입력해주세요.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1234", "1230", "1200", "100"})
    @DisplayName("1000으로 나누어 떨어지지 않는 값을 넣을 때 에러가 발생한다.")
    void 가격입력_1000의_배수가_아닌값_체크(String value) {
        assertThatThrownBy(() -> new Customer(value))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 1000으로 나누어 떨어지는 수를 입력해주세요.");
    }

    @Test
    @DisplayName("고객이 로또를 사면 크기가 1 늘어난다.")
    void 구매() {
        Customer customer = new Customer("1000");

        customer.buy(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        Assertions.assertEquals(customer.getLottoSize(), 1);
    }
}
