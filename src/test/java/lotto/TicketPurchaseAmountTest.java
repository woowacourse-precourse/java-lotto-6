package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.domain.TicketPurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
public class TicketPurchaseAmountTest {
    @ParameterizedTest
    @ValueSource(strings = {"0", "1100", "-1", "abc"})
    @DisplayName("올바르지 않은 금액")
    void failed(String input) {
        assertThatThrownBy(() -> new TicketPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매한 로또 개수 구하기")
    void calculateLottoCount() {
        TicketPurchaseAmount amount = new TicketPurchaseAmount("1000");
        assertThat(amount.calculateLottoCount()).isEqualTo(1);
    }
    @Test
    void shouldThrowExceptionForNonNumericInput() {
        String input = "1000j";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new TicketPurchaseAmount(input);
        });
        String expectedMessage = "금액은 숫자만 등록 가능합니다.";
        assertEquals(expectedMessage, exception.getMessage());
    }
}
