package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class ControllerTest {
    private final Validator valiator = Validator.getInstance();

    @Test
    void readLottoMoney_공백_이면_예외반환() {
        assertThatThrownBy(() -> valiator.validateLottoMoney(" ")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void readLottoMoney_null_이면_예외반환() {
        assertThatThrownBy(() -> valiator.validateLottoMoney(null)).isInstanceOf(IllegalArgumentException.class);
    }
}

