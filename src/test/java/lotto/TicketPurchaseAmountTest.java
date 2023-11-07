package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
}
