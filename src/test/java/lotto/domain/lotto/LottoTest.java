package lotto.domain.lotto;

import java.util.List;
import java.util.stream.Stream;
import lotto.global.constant.message.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    @ParameterizedTest
    @MethodSource("validNumberAmountParameters")
    void 로또_번호가_6개가_아니면_예외_발생(List<Integer> numbers) {
        Assertions.assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBER_AMOUNT_ERROR);
    }

    static Stream<Arguments> validNumberAmountParameters() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7)),
                Arguments.of(List.of(1, 2, 3, 4, 5)),
                Arguments.of(List.of(1, 2, 3, 4)),
                Arguments.of(List.of(1, 2, 3)),
                Arguments.of(List.of(1, 2)),
                Arguments.of(List.of(1))
        );
    }

    @ParameterizedTest
    @MethodSource("validNumberRangeParameters")
    void 로또_번호의_범위가_1부터_45사이가_아니면_예외_발생(List<Integer> numbers) {
        Assertions.assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR);
    }

    static Stream<Arguments> validNumberRangeParameters() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 46)),
                Arguments.of(List.of(0, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(1, 47, 71, 88, 101, 9))
        );
    }

    @ParameterizedTest
    @MethodSource("validNumberDuplicationParameters")
    void 로또_번호가_중복되면_예외_발생(List<Integer> numbers) {
        Assertions.assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBER_DUPLICATION_ERROR);
    }

    static Stream<Arguments> validNumberDuplicationParameters() {
        return Stream.of(
                Arguments.of(List.of(1, 1, 2, 3, 4, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 5)),
                Arguments.of(List.of(11, 22, 33, 44, 44, 45))
        );
    }
}
