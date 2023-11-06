package lotto;

import static lotto.domain.winningnumbers.WinningNumbersErrorMessage.BONUS_NUMBER_DUPLICATION_ERROR;
import static lotto.domain.winningnumbers.WinningNumbersErrorMessage.BONUS_NUMBER_INVALID_RANGE;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.winningnumbers.WinningNumbers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningNumbersTest {

    @Test
    void 보너스_번호_중복() {
        //given
        List<Integer> numbers = List.of(1,2,3,4,5,6);
        int bonusNumber = 1;

        //when,then
        assertThatThrownBy(() -> new WinningNumbers(numbers,bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_NUMBER_DUPLICATION_ERROR.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,46})
    void 보너스_번호_범위_초과(int bonusNumber) {
        //given
        List<Integer> numbers = List.of(1,2,3,4,5,6);

        //when,then
        assertThatThrownBy(() -> new WinningNumbers(numbers,bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_NUMBER_INVALID_RANGE.getMessage());
    }

    @ParameterizedTest
    @MethodSource("provideValidWinningNumbersAndBonusNumber")
    void 당첨_번호와_보너스_번호_생성_성공(List<Integer> winningNumbers, int bonusNumber) {

        //when, then
        assertThatCode(() -> new WinningNumbers(winningNumbers, bonusNumber))
                .doesNotThrowAnyException();
    }

    private static Stream<Arguments> provideValidWinningNumbersAndBonusNumber() {
        return Stream.of(
                Arguments.of(List.of(1,2,3,4,5,6),7),
                Arguments.of(List.of(10,13,21,22,30,44),42),
                Arguments.of(List.of(5,10,23,35,41,45),1),
                Arguments.of(List.of(4,10,13,20,23,31),30)
        );
    }
}
