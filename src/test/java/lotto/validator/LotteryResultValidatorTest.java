package lotto.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LotteryResultValidatorTest {
    @ParameterizedTest
    @MethodSource
    void 보너스_번호가_당첨_번호와_중복된_숫자가_존재할때_예외처리(List<Integer> lottoNumbers, int bonusNumber) {
        //given
        //when
        Throwable result = catchThrowable(
                () -> {
                    LotteryResultValidator.bonusNumberDuplicated(lottoNumbers, bonusNumber);
                });
        //then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);

    }

    private static Stream<Arguments> 보너스_번호가_당첨_번호와_중복된_숫자가_존재할때_예외처리() {
        return Stream.of(
                Arguments.of(new ArrayList<>(Arrays.asList(6, 5, 4, 3, 2, 1))
                        , 6),
                Arguments.of(new ArrayList<>(Arrays.asList(45, 35, 25, 15, 5, 1)),
                        5),
                Arguments.of(new ArrayList<>(Arrays.asList(1, 2, 3, 6, 5, 4)),
                        4),
                Arguments.of(new ArrayList<>(Arrays.asList(11, 21, 12, 22, 13, 33)),
                        22),
                Arguments.of(new ArrayList<>(Arrays.asList(1, 2, 9, 8, 4, 3)),
                        9)

        );
    }
}
