package lotto.utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParserTest {

    @DisplayName("숫자가 아닌 예산을 파싱하는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"백만원", "hundredDollors"})
    void 문자예산을_파싱하는_경우(String input) {
        assertThatThrownBy(() -> Parser.parseBudget(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ExceptionMessage.INVALID_BUDGET_NON_NUMERIC.getMessage());
    }

    @Test
    void parseNullBudget() {
        String input = null;
        assertThatThrownBy(() -> Parser.parseBudget(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ExceptionMessage.INVALID_BUDGET_NON_NUMERIC.getMessage());
    }

}