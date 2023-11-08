package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SplitNumberTest {
    private static final String NOT_A_NUMBER_MESSAGE = "입력은 숫자여야 합니다";
    private static final String UNDER_20_BILLION_REQUIRED = "입력은 20억 이하여야 합니다";

    @Test
    @DisplayName("정상동작")
    void good_case() {
        String input = "1,2,3,4,5";
        List<Integer> list = SplitNumber.splitNumber(input);

        assertThat(list).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    @DisplayName("숫자가 아닐 때 예외")
    void 숫자가_아닐_때_예외() {
        String input = "1,2,3,4,안녕";

        assertThatThrownBy(() -> SplitNumber.splitNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_A_NUMBER_MESSAGE);
    }

    @ParameterizedTest
    @CsvSource(value = {"2000000001", "10000000000", "100000000000000"})
    @DisplayName("입력이 20억 이상일 때 예외")
    void 입력이_20억_이상일_때_예외(String number) {
        String input = "1,2,3,4," + number;

        assertThatThrownBy(() -> SplitNumber.splitNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(UNDER_20_BILLION_REQUIRED);
    }
}