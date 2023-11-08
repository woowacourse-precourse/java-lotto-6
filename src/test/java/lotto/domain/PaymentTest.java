package lotto.domain;

import lotto.domain.Payment;
import lotto.validator.Validator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("구입 금액 테스트")
public class PaymentTest {

    @ParameterizedTest
    @DisplayName("입력이 정수가 아니면 예외를 날리는 지 테스트한다.")
    @ValueSource(strings = {",", "a"})
    void 입력_정수테스트(String input) {
        Assertions.assertThatThrownBy(() -> Validator.isPrimeNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("음수나 0을 넣었을 때 예외를 던지는 지 테스트한다.")
    @ValueSource(ints = {-1, 0})
    void 입력_음수테스트(int input) {
        Assertions.assertThatThrownBy(() -> new Payment(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("로또금액 단위에 안 맞으면 예외를 던지는 지 테스트한다.")
    @ValueSource(ints = {100, 1100})
    void 입력_단위테스트(int input) {
        Assertions.assertThatThrownBy(() -> new Payment(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("구입 금액 통합 테스트")
    @ValueSource(ints = {1000, 5000})
    void 구입_금액_통합테스트(int input) {
        Assertions.assertThatCode(() -> new Payment(input))
                .doesNotThrowAnyException();
    }

}
