package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class GameTest {
    Game test = new Game();

    @DisplayName("입력 받은 금액이 잘 체크되는지 확인")
    @Test
    void validateNumberTest() {
        assertThat(test.validateNumber("1000")).isEqualTo(1000);
        assertThatThrownBy(() -> test.validateNumber("1234"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> test.validateNumber("asdfasdf"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수익률 계산 체크")
    @Test
    void printRevenueTest() {
        int cost = 8000;
        int revenue = 5000;

        double rate = ((double)revenue / (double)cost) * 100;
        assertThat(rate).isEqualTo(62.5);
    }
}
