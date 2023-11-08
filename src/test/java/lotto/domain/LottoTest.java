package lotto.domain;

import static lotto.option.Error.NOT_LOTTO_DUPLICATION;
import static lotto.option.Error.NOT_SIX_LENGTH;
import static lotto.option.Error.ONE_TO_FORTY_FIVE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {
    @DisplayName("List의 길이가 6이 아니면 예외가 발생한다.")
    @Test
    void NotSixNumberLengthThrowException() {
        //given
        //when
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                //then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_SIX_LENGTH.getMessage());
    }

    @DisplayName("범위를 벗어난 수를 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("invalidParameters")
    void overRangeThrowException(List<Integer> numbers) {
        //given
        //when
        assertThatThrownBy(() -> new Lotto(numbers))
                //then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ONE_TO_FORTY_FIVE.getMessage());
    }

    static Stream<Arguments> invalidParameters() {
        return Stream.of(
                Arguments.of(List.of(0, 1, 2, 3, 4, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 46))
        );
    }

    @DisplayName("로또 번호가 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void ifDuplicationThrowException() {
        //given
        //when
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                //then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_LOTTO_DUPLICATION.getMessage());
    }

}