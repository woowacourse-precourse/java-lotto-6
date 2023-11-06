package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPurchaseAmountTest {

    @DisplayName("로또 구매 가격이 숫자가 아니면 예외가 발생한다.")
    @Test
    void validateInt() {
        // given
        String input = "문자";

        // when & then
        assertThatThrownBy(() -> new LottoPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 가격이 0 또는 음수이면 예외가 발생한다.")
    @Test
    void validateAmount_Not_Positive_Number() {
        // given
        String zero = "0";
        String negativeNum = "-1000";

        // when & then
        assertThatThrownBy(() -> new LottoPurchaseAmount(zero))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoPurchaseAmount(negativeNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 가격이 1000원으로 나누어 떨어지지 않을 경우 예외가 발생한다.")
    @Test
    void validateAmount_Not_Divide_Lotto_Ticket_Price() {
        // given
        String notDivideLottoTicketPrice = "1004";

        // when & then
        assertThatThrownBy(() -> new LottoPurchaseAmount(notDivideLottoTicketPrice))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
