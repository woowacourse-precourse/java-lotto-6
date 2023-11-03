package lotto.model.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyRequestDtoTest {
    @DisplayName("사용자에게 숫자가 아닌 로또 구입 금액을 입력 받아 예외 발생을 테스트한다.")
    @Test
    void createPlayerByNonNumberValid() {
        assertThatThrownBy(() -> new MoneyRequestDto("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}