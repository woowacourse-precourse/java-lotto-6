package lotto;

import static lotto.domain.winningnumbers.WinningNumbersErrorMessage.BONUS_NUMBER_DUPLICATION_ERROR;
import static lotto.domain.winningnumbers.WinningNumbersErrorMessage.BONUS_NUMBER_INVALID_RANGE;
import static org.assertj.core.api.Assertions.*;

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

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    void 해당_번호가_당첨_번호에_속한다(int number) {
        //given
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        //when, then
        assertThat(winningNumbers.isInWinningNumbers(number)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {7,8,9,10,11,12})
    void 해당_번호가_당첨_번호에_속하지_않는다(int number) {
        //given
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        //when, then
        assertThat(winningNumbers.isInWinningNumbers(number)).isEqualTo(false);
    }

    @Test
    void 해당_번호가_보너스_번호와_일치한다() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        int number = 7;

        //when, then
        assertThat(winningNumbers.isSameWithBonusNumber(number)).isEqualTo(true);
    }

    @Test
    void 해당_번호가_보너스_번호와_일치하지_않는다() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        int number = 1;

        //when, then
        assertThat(winningNumbers.isSameWithBonusNumber(number)).isEqualTo(false);
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
