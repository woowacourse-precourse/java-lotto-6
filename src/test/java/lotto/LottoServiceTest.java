package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    public void setUp() {
        lottoService = new LottoService();
    }

    @DisplayName("숫자가 1000으로 나눠 떨어지지 않을 경우 예외 발생.")
    @Test
    void testIsPurchaseAmountDivideBy1000() {
        String input = "10001";
        assertThatThrownBy(() -> {
            lottoService.isPurchaseAmountDivideBy1000(input);
        })
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(ErrorMessage.PURCHASE_NOT_DIVIDE_BY_1000.getMessage());
    }

    @DisplayName("숫자가 45를 넘을 경우 예외 발생.")
    @Test
    void isNumberOverLimit() {
        String input = "46";
        assertThatThrownBy(() -> {
            lottoService.isNumberOverLimit(input);
        })
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(ErrorMessage.NUMBER_OVER_LIMIT.getMessage());
    }
}