package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BuyTest {
    @DisplayName("구입 금액을 저장한다.")
    @Test
    void 구입_금액을_정상적으로_저장하는_경우() {
        assertThatCode(() -> new Buy("5000"))
                .doesNotThrowAnyException();
    }

    @DisplayName("문자를 입력한 경우 예외가 발생한다.")
    @Test
    void 문자를_입력한_경우() {
        assertThatThrownBy(() -> new Buy("1234문자열"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원 미만 금액을 입력한 경우 예외가 발생한다.")
    @Test
    void 천원_미만_금액을_입력한_경우() {
        assertThatThrownBy(() -> new Buy("300"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원 단위가 아닌 경우 예외가 발생한다.")
    @Test
    void 천원_단위가_아닌_경우() {
        assertThatThrownBy(() -> new Buy("5900"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
