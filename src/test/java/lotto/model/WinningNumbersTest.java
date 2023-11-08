package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumbersTest {

    @DisplayName("당첨번호의 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void 당첨번호_개수_예외_처리() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4);

        //when,then
        assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WINNING_NUMBER_SIZE_ERROR.getErrorMessage());
    }

    @DisplayName("당첨번호가 중복되면 예외가 발생한다.")
    @Test
    void 당첨번호_중복_예외_처리() {
        //given
        List<Integer> numbers = List.of(1, 1, 1, 3, 3, 3);

        //when,then
        assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WINNING_NUMBER_DUPLICATE_ERROR.getErrorMessage());
    }

    @DisplayName("당첨번호에 1미만의 숫자가 있으면 예외가 발생한다.")
    @Test
    void 당첨번호_범위_미만_예외_처리() {
        //given
        List<Integer> numbers = List.of(-88, 1, 2, 3, 4, -90);

        //when,then
        assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.RANGE_ERROR.getErrorMessage());
    }


    @DisplayName("당첨번호에 45초과인 숫자가 있으면 예외가 발생한다.")
    @Test
    void 당첨번호_범위_초과_예외_처리() {
        //given
        List<Integer> numbers = List.of(88, 1, 2, 3, 4, 90);

        //when,then
        assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.RANGE_ERROR.getErrorMessage());
    }

    @DisplayName("생성시 입력한 당첨번호가 존재한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void 당첨번호_생성_기능(int number) {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        //when
        final WinningNumbers winningNumbers = new WinningNumbers(numbers);

        //then
        assertTrue(winningNumbers.containNumber(number));
    }
}
