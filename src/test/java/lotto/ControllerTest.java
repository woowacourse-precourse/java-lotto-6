package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.util.Utils;
import lotto.util.Validator;
import org.junit.jupiter.api.Test;

public class ControllerTest {

    @Test
    void parseInt_숫자반환_테스트() {
        assertThat(Utils.parseInt("123")).isEqualTo(123);
    }

    @Test
    void readLottoMoney_숫자_아니면_예외반환() {
        assertThatThrownBy(() -> Validator.validateInputString("abc")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void readLottoMoney_공백_이면_예외반환() {
        assertThatThrownBy(() -> Validator.validateHasInput(" ")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void readLottoMoney_null_이면_예외반환() {
        assertThatThrownBy(() -> Validator.validateHasInput(null)).isInstanceOf(IllegalArgumentException.class);
    }
}

