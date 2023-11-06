package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.util.Validator;
import org.junit.jupiter.api.Test;

public class ControllerTest {

    @Test
    void readLottoMoney_공백_이면_예외반환() {
        assertThatThrownBy(() -> Validator.validateHasInput(" ")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void readLottoMoney_null_이면_예외반환() {
        assertThatThrownBy(() -> Validator.validateHasInput(null)).isInstanceOf(IllegalArgumentException.class);
    }
}

