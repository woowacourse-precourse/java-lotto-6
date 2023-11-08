package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {
    @DisplayName("보너스 번호가 문자를 포함하면 예외가 발생한다.")
    @Test
    void createBonusByNotNumber() {
        assertThatThrownBy(() -> new Number("1a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
