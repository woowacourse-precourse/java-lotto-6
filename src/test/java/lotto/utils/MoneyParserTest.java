package lotto.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MoneyParserTest {
    @DisplayName("금액 입력시 숫자가 아닌 문자를 포함할 수 없고, 0으로 시작할 수 없다.")
    @ParameterizedTest(name = "입력 금액: {0}")
    @CsvSource(value = {"1000f", "ff", "adsf00","012"})
    void parseMoneyByNonNumber(String inputMoney) {
        assertThatThrownBy(() -> MoneyParser.parseMoney(inputMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("금액을 올바르게 입력하세요.");
    }

    @DisplayName("금액 입력시 빈 문자열을 입력할 수 없다.")
    @ParameterizedTest(name = "입력 금액: {0}")
    @CsvSource(value = {" ","''"},ignoreLeadingAndTrailingWhitespace = false) //공백만 입력했을때와와 아무것도 입력하지 않았을때를 검증
    void parseMoneyByEmptyString(String inputMoney) {
        assertThatThrownBy(() -> MoneyParser.parseMoney(inputMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 없습니다.");
    }
}
