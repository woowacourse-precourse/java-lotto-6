package lotto.domain;

import static common.enumtype.ErrorCode.LOTTO_NUMBERS_INVALID_RANGE;
import static common.enumtype.ErrorCode.LOTTO_NUMBERS_INVALID_SIZE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 번호 검증")
class LottoTest {

    @Test
    void 로또_번호_6개_이상_예외() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        // when
        // then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBERS_INVALID_SIZE.getMessage());
    }

    @Test
    void 로또_번호_중복된_숫자_예외() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        // when
        // then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_45초과_번호_포함_예외() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);

        // when
        // then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBERS_INVALID_RANGE.getMessage());
    }

    @Test
    void 로또_번호_1미만_번호_포함_예외() {
        // given
        List<Integer> numbers = List.of(0, 2, 3, 4, 5, 6);

        // when
        // then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBERS_INVALID_RANGE.getMessage());
    }
}
