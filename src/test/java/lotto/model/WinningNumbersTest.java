package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}
