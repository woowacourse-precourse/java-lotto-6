package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.view.message.Error;
import org.junit.jupiter.api.DisplayName;
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
}
