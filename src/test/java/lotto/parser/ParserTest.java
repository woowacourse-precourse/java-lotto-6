package lotto.parser;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParserTest {
    @DisplayName("정수를 입력하지 않으면 예외가 발생한다.")
    @Test
    void inputPurchaseAmount() {
        assertThatThrownBy(() -> Parser.parsePurchaseAmount("3.14"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~45 사이 정수 6개를 입력하지 않으면 예외가 발생한다.")
    @Test
    void inputWinningNumbers() {
        assertThatThrownBy(() -> Parser.parseWinningNumbers("1, 2, 3, 4, 3 5, 6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력해주세요.");
    }
}
