package lotto.model;

import static lotto.Message.ErrorMessage.AMOUNT_RANGE_ERROR_MESSAGE;
import static lotto.Message.ErrorMessage.AMOUNT_UNIT_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AmountTest {
    @DisplayName("model_Amount_0이_입력_했을_때")
    @Test
    public void model_Amount_0_input() {
        int inputAmount = 0;

        assertThatThrownBy(() -> new Amount(inputAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(AMOUNT_RANGE_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("model_Amount_1000000이_입력_했을_때")
    @Test
    public void model_Amount_1000000_input() {
        int inputAmount = 1000000;

        assertThatThrownBy(() -> new Amount(inputAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(AMOUNT_RANGE_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("model_Amount_2001이_입력_했을_때")
    @Test
    public void model_Amount_2001_input() {
        int inputAmount = 2001;

        assertThatThrownBy(() -> new Amount(inputAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(AMOUNT_UNIT_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("model_Amount_2000이_입력_했을_때")
    @Test
    public void model_Amount_2000_input() {
        int inputAmount = 2000;
        Amount amount = new Amount(inputAmount);

        assertThat(amount.getAmount()).isEqualTo(2000);
    }
}
