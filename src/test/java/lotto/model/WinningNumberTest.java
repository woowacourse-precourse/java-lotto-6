package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.view.message.Error;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningNumberTest {

    @DisplayName("당첨 번호가 6개가 아닌 경우 에러를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,3,2,6,22", "3,4,5,6,7,8,9"})
    public void 여섯개가_아닌_당첨_번호_예외처리(String input) {
        //when+then
        assertThatThrownBy(() -> {
            WinningNumber.create(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Error.WINNING_NUMBER_OVERSIZE.getMessage());
    }

    @DisplayName("당첨 번호가 정수가 아닌 문자가 포함된 경우 에러를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,c", "0.1,2,3,4,5,6", ",2,3,4,5,6", " ,2,3,4,5,6"})
    public void 정수가_아닌_당첨번호_예외처리(String input) {
        //when+then
        assertThatThrownBy(() -> {
            WinningNumber.create(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Error.WINNING_NUMBER_NOT_INTEGER.getMessage());
    }

    @DisplayName("당첨 번호가 1에서 45 사이의 숫자가 아닌 경우 에러를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"0,2,3,4,5,6", "-5,1,2,3,4,5", "1,2,3,4,5,46"})
    public void 범위에서_벗어난_당첨번호_예외처리(String input) {
        //when+then
        assertThatThrownBy(() -> {
            WinningNumber.create(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Error.WINNING_NUMBER_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있을 경우 에러를 발생시킨다.")
    @Test
    public void 중복된_당첨번호_예외처리() {
        //given
        String duplicateWinningNumber = "1,2,3,4,5,5";

        //when+then
        assertThatThrownBy(() -> {
            WinningNumber.create(duplicateWinningNumber);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Error.WINNING_NUMBER_DUPLICATED.getMessage());
    }

    @DisplayName("올바른 당첨번호 입력시 당첨번호 인스턴스를 생성한다.")
    @Test
    public void 올바른_당첨번호_입력() {
        //given
        String validWinningNumber = "3,5,13,43,22,42";
        List<Integer> winningNumbers = Arrays.asList(3, 5, 13, 43, 22, 42);

        //when
        WinningNumber winningNumber = WinningNumber.create(validWinningNumber);

        //then
        assertThat(winningNumber.getWinningNumbers().containsAll(winningNumbers)).isTrue();
    }
}
