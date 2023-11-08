package lotto.util;

import static lotto.exception.ErrorMessage.COMMA_START_END;
import static lotto.exception.ErrorMessage.HAS_REMAINING_NUMBER;
import static lotto.exception.ErrorMessage.HAS_SPACE;
import static lotto.exception.ErrorMessage.NOT_INTEGER;
import static lotto.exception.ErrorMessage.NUMBER_DUPLICATE;
import static lotto.exception.ErrorMessage.NUMBER_MISS;
import static lotto.exception.ErrorMessage.SIZE_MISS;
import static lotto.util.Validator.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    @DisplayName("숫자 아닐 경우 예외 발생")
    void testNotInteger() {
        String input = "asdf";

        assertThatThrownBy(() -> validateIsInteger(input))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(NOT_INTEGER.getMessage());
    }

    @Test
    @DisplayName("리스트의 문자열이 숫자 아닐 경우 예외 발생")
    void testListNotInteger() {
        List<String> input = new ArrayList<>();
        input.add("asdf");

        assertThatThrownBy(() -> validateListIsInteger(input))
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

    @Test
    @DisplayName("콤마로 시작하거나 끝날 경우 예외 발생")
    void testCommaStartEnd() {
        String input = ",asdf";

        assertThatThrownBy(() -> validateCommaStartEnd(input))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(COMMA_START_END.getMessage());
    }

    @Test
    @DisplayName("로또 번호가 약속된 크기와 다를 경우 예외 발생")
    void testLottoSizeMiss() {
        List<Integer> input = new ArrayList<>();
        input.add(3);

        assertThatThrownBy(() -> validateSizeMiss(input))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(SIZE_MISS.getMessage());
    }

    @Test
    @DisplayName("각 로또 번호의 크기가 규정보다 작거나 클 경우 예외 발생")
    void testNumberMinimumOrMaximum() {
        List<Integer> input = new ArrayList<>();
        input.add(55);
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(5);

        assertThatThrownBy(() -> validateListNumberMinimumOrMaximum(input))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(NUMBER_MISS.getMessage());
    }

    @Test
    @DisplayName("숫자가 겹칠 경우 예외 발생")
    void testNumberDuplicate() {
        List<Integer> input = new ArrayList<>();
        input.add(34);
        input.add(34);

        assertThatThrownBy(() -> validateDuplicateNumber(input))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(NUMBER_DUPLICATE.getMessage());
    }
}