package lotto.util;

import static lotto.exception.ErrorMessage.HAS_REMAINING_NUMBER;
import static lotto.exception.ErrorMessage.HAS_SPACE;
import static lotto.exception.ErrorMessage.NOT_INTEGER;
import static lotto.util.Validator.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.LottoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    String userInput;
    List<Integer> inputLottoNumbers;

    @BeforeEach
    void reset() {

    }

    @Test
    @DisplayName("숫자 아닐 경우 예외 발생")
    void testNotInteger() {
        String input = "asdf";

        assertThatThrownBy(() -> validateIsInteger(input))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(NOT_INTEGER.getMessage());
    }

    @Test
    @DisplayName("공백 포함 시 예외 발생")
    void testHasSpace() {
        String input = "as df";

        assertThatThrownBy(() -> validateHasSpace(input))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(HAS_SPACE.getMessage());
    }

    @Test
    @DisplayName("1000 단위로 떨어지지 않는 경우 예외 발생")
    void testHasRemainingNumber() {
        Integer input = 1800;

        assertThatThrownBy(() -> validateHasRemainingNumber(input))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(HAS_REMAINING_NUMBER.getMessage());
    }
}