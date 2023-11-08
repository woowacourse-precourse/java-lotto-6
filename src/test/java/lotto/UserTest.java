package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.User.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {
    @DisplayName("올바르지 않은 금액을 입력하면 예외가 발생한다.")
    @Test
    void wrongMoney() {
        String input = "-10";
        assertThatThrownBy(() -> PaperNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액에 맞춰 로또 장수가 출력된다.")
    void makeTickets() {
        String inputAmount = "3000";
        assertThat(PaperNumber(inputAmount)).isEqualTo(3);
    }
}
