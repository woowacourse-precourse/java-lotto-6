package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constants.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {
    @DisplayName("유효한 구매 금액 문자열을 정수로 파싱한다.")
    @Test
    void parseValidPurchaseAmount() {
        String validInput = "2000";
        int purchaseAmount = Parser.parsePurchaseAmount(validInput);

        assertThat(purchaseAmount).isEqualTo(2000);
    }

    @DisplayName("유효하지 않은 구매 금액 문자열을 파싱하면 예외가 발생한다.")
    @Test
    void parseInvalidPurchaseAmount() {
        String invalidInput = "not_a_number";

        assertThatThrownBy(() -> Parser.parsePurchaseAmount(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INTEGER_REQUIRED.getMessage());
    }

    @DisplayName("유효한 당첨 번호 문자열을 정수 목록으로 파싱한다.")
    @Test
    void parseValidWinningNumbers() {
        String validInput = "1, 2, 3, 4, 5, 6";

        assertThat(Parser.parseWinningNumbers(validInput)).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("유효하지 않은 당첨 번호 문자열을 파싱하면 예외가 발생한다.")
    @Test
    void parseInvalidWinningNumbers() {
        String invalidInput = "1, 2, 3, not_a_number, 5, 6";

        assertThatThrownBy(() -> Parser.parseWinningNumbers(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INTEGER_REQUIRED.getMessage());
    }

    @DisplayName("유효한 보너스 번호 문자열을 정수로 파싱한다.")
    @Test
    void parseValidBonusNumber() {
        String validInput = "7";
        int bonusNumber = Parser.parseBonusNumber(validInput);

        assertThat(bonusNumber).isEqualTo(7);
    }

    @DisplayName("유효하지 않은 보너스 번호 문자열을 파싱하면 예외가 발생한다.")
    @Test
    void parseInvalidBonusNumber() {
        String invalidInput = "not_a_number";

        assertThatThrownBy(() -> Parser.parseBonusNumber(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INTEGER_REQUIRED.getMessage());
    }
}
