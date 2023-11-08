package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PriceValidatorTest {

    @DisplayName("1000원 단위의 입력이 아니면 예외가 발생한다.")
    @Test
    void 금액_단위_입력_오류_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            PriceValidator.validate("1");
        });
    }

    @DisplayName("입력이 숫자가 아니면 예외가 발생한다.")
    @Test
    void 금액_입력_숫자_오류_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            PriceValidator.validate("1..");
        });
    }
}