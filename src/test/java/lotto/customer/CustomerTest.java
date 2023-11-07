package lotto.customer;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CustomerTest {

    @ParameterizedTest
    @CsvSource(value = {"0", "d123", "123d", "1000.", "!1000"})
    @DisplayName("자연수가 아닌 값을 넣을 때 에러가 발생한다.")
    void 가격입력_숫자이외의값_입력() {
        String conatinNotInteger = "ㅇ1234";

        assertThatThrownBy(() -> new Customer(conatinNotInteger))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자연수 형태의 값을 입력해주세요.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1234", "1230", "1200", "100"})
    @DisplayName("1000으로 나누어 떨어지지 않는 값을 넣을 때 에러가 발생한다.")
    void 가격입력_1000의_배수가_아닌값_체크(String value) {
        assertThatThrownBy(() -> new Customer(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 0으로 나누어 떨어지는 수를 입력해주세요.");
    }
}
