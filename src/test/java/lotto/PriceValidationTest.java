package lotto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class PriceValidationTest {
    @Test
    void validatePrice() {
        assertThatThrownBy(() -> new PriceValidation(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 금액을 1000원 단위로 입력해야 합니다.");

        assertThat(new PriceValidation(2000).createCount()).isEqualTo(2);
    }
}
