package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AmountTest extends Amount{

    @Test
    void 숫자문자열을_숫자로_변환() {

        //given
        String money = "8000";

        //when
        int result = stringToInt(money);

        //then
        assertThat(result).isEqualTo(8000);
    }

    @Test
    void 입력문자열이_숫자인지_확인() {

        //given
        String input = "8000";

        //when
        int result = isNum(input);

        //then
        assertThat(result).isEqualTo(8000);
    }

    @ParameterizedTest
    @ValueSource(strings = {"ten", "1a", "a12"})
    void 입력문자열이_숫자가_아닌_경우_예외처리(String input) {
        assertThatThrownBy(() -> isNum(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 금액 값은 숫자여야 합니다.");
    }
}