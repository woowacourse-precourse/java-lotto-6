package lotto.domain;

import static lotto.enums.ErrorMessage.OUT_OF_RANGE_LOTTO_NUMBER;
import static lotto.enums.LottoConfig.MAX_LOTTO_NUMBER;
import static lotto.enums.LottoConfig.MIN_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class LottoNumberTest {
    private static List<Integer> provideNumbers() {
        return IntStream.rangeClosed(MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue())
                .boxed()
                .toList();
    }

    @ParameterizedTest
    @MethodSource("provideNumbers")
    void 숫자가_LOTTO_MIN_NUMBER과_LOTTO_MAX_NUMBER사이일_경우_객체를_올바르게_생성한다(int number) {
        // when & then
        assertDoesNotThrow(() -> LottoNumber.from(number));
    }

    @Test
    void 숫자가_LOTTO_MIN_NUMBER보다_작을_경우_예외가_발생한다() {
        // given
        int number = MIN_LOTTO_NUMBER.getValue() - 1;

        // when & then
        assertThatThrownBy(() -> LottoNumber.from(number))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(OUT_OF_RANGE_LOTTO_NUMBER.getMassage());
    }

    @Test
    void 숫자가_LOTTO_MAX_NUMBER보다_클_경우_예외가_발생한다() {
        // given
        int number = MAX_LOTTO_NUMBER.getValue() + 1;

        // when & then
        assertThatThrownBy(() -> LottoNumber.from(number))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(OUT_OF_RANGE_LOTTO_NUMBER.getMassage());
    }
}