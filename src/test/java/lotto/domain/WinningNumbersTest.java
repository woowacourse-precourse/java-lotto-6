package lotto.domain;

import static common.ErrorCode.WINNING_NUMBERS_DUPLICATED;
import static common.ErrorCode.WINNING_NUMBERS_INVALID_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("당첨 번호 검증")
class WinningNumbersTest {

    @Test
    void 당첨_번호_6개_미만_예외() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // when
        // then
        assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WINNING_NUMBERS_INVALID_SIZE.getMessage());
    }

    @Test
    void 당첨_번호_6개_초과_예외() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        // when
        // then
        assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WINNING_NUMBERS_INVALID_SIZE.getMessage());
    }

    @Test
    void 중복된_당첨_번호_에외() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        // when
        // then
        assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WINNING_NUMBERS_DUPLICATED.getMessage());
    }

    @Test
    void 당첨_번호_생성() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        WinningNumbers result = new WinningNumbers(numbers);

        // then
        assertThat(result).isNotNull();
    }
}
