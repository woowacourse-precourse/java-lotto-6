package lotto.method;

import lotto.Validation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {

    @DisplayName("로또 금액이 모든 검증을 통과하면 입력값을 정수로 변환하여 반환한다.")
    @Test
    void 로또_금액_입력값_정상() {
        Assertions.assertThat(Validation.getLottoPrice("1000"))
                .isEqualTo(1000);
    }

    @DisplayName("로또 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void 로또_금액_입력값_숫자가_아님() {
        assertThatThrownBy(() -> Validation.getLottoPrice("1000d"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 금액이 정수 범위 밖이면 예외가 발생한다.(Integer.MAX_VALUE)")
    @Test
    void 로또_금액_입력값_정수_범위_밖() {
        assertThatThrownBy(() -> Validation.getLottoPrice("3000000000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 금액이 1000보다 작으면 예외가 발생한다.")
    @Test
    void 로또_금액_입력값_1000보다_작은값() {
        assertThatThrownBy(() -> Validation.getLottoPrice("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void 로또_금액_입력값_1000단위가_아닌값() {
        assertThatThrownBy(() -> Validation.getLottoPrice("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
