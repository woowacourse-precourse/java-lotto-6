package lotto.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoValidatorTest {

    @ParameterizedTest
    @MethodSource
    void 로또_번호의_개수가_6개보다_작다면_예외가_발생한다(List<Integer> lottoNumbers) {
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);

    }

    private static Stream<Arguments> 로또_번호의_개수가_6개보다_작다면_예외가_발생한다() {
        return Stream.of(
                Arguments.of(new ArrayList<>(Arrays.asList(6, 5, 4, 3, 2))),
                Arguments.of(new ArrayList<>(Arrays.asList(45, 35, 25, 15, 5))),
                Arguments.of(new ArrayList<>(Arrays.asList(1, 2, 3, 6, 5))),
                Arguments.of(new ArrayList<>(Arrays.asList(11, 21, 12, 22, 13))),
                Arguments.of(new ArrayList<>(Arrays.asList(1, 2, 9, 8, 4)))

        );
    }

    @ParameterizedTest
    @MethodSource
    void 로또숫자가_1부터_45의_범위를_벗어났을때_예외처리(List<Integer> lottoNumbers) {
        //given

        //when
        Throwable result = catchThrowable(() -> {
            lottoNumbers.forEach(LottoValidator::numberOverValueRange);

        });
        //then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> 로또숫자가_1부터_45의_범위를_벗어났을때_예외처리() {
        return Stream.of(
                Arguments.of(new ArrayList<>(Arrays.asList(6, 5, 4, 3, 2, 450))),
                Arguments.of(new ArrayList<>(Arrays.asList(45, 35, 25, 150, 5, 1))),
                Arguments.of(new ArrayList<>(Arrays.asList(1, 2, 3, 60, 5, 4))),
                Arguments.of(new ArrayList<>(Arrays.asList(11, 210, 12, 22, 13, 33))),
                Arguments.of(new ArrayList<>(Arrays.asList(100, 2, 9, 8, 4, 3)))

        );
    }
}
