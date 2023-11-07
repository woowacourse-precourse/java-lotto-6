package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoValidatorTest {

    private static final String ERROR = "[ERROR]";
    private static final String DUPLICATE_ERROR_MESSAGE = "중복된 로또 번호가 있습니다.";
    private static final String SIZE_OVER_MESSAGE = "로또 번호가 6개가 아닙니다.";
    private static final String RANGE_OVER_MESSAGE = "로또 번호가 1이상 45이하가 아닙니다.";
    private static final String NOT_SORT_MESSAGE = "로또가 오름차순이 아닙니다.";
    private LottoValidator validator;

    @Test
    @DisplayName("로또 숫자 중복이면 예외 처리")
    void isDuplicate() {
        List<Integer> input = List.of(1, 3, 3, 4, 5, 6);
        assertThatThrownBy(() -> validator = new LottoValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR + DUPLICATE_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("로또 숫자 갯수가 6개가 아니면 예외 처리")
    void isSizeOver() {
        List<Integer> input = List.of(1, 3, 3, 4, 5, 6, 7);
        assertThatThrownBy(() -> validator = new LottoValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR + SIZE_OVER_MESSAGE);
    }

    @Test
    @DisplayName("로또 숫자가 1이상 45이하가 아닐 시 예외 처리")
    void isRangeOver() {
        List<Integer> input = List.of(1, 86, 3, 4, 5, 6);
        assertThatThrownBy(() -> validator = new LottoValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR + RANGE_OVER_MESSAGE);
    }

    @Test
    @DisplayName("로또 숫자가 오름차순이 아니면 예외 처리")
    void isSorted() {
        List<Integer> input = List.of(1, 4, 3, 2, 5, 6);
        assertThatThrownBy(() -> validator = new LottoValidator(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR + NOT_SORT_MESSAGE);
    }

}
