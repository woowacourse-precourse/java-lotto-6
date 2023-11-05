package lotto.domain;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class LuckyNumbersTest {
    @DisplayName("당첨번호 및 보너스 번호 테스트")
    @Test
    void testLuckyNumbers() {
        LuckyNumbers luckyNumbers = new LuckyNumbers(10, List.of(1,2,3,4,5,6));
        assertThat(luckyNumbers.getBonusNumber()).isEqualTo(10);
        assertThat(luckyNumbers.getWinningNumbers()).isEqualTo(List.of(1,2,3,4,5,6));
    }

    @DisplayName("당첨번호 및 보너스 번호 예외 테스트")
    @Test
    void errorLuckyNumbers() {
        assertThatThrownBy(() -> new LuckyNumbers(10, List.of(1, 2, 3, 4, 5, 6, 10)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
