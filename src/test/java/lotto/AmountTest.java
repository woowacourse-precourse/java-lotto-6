package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatNoException;

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
    void 입력문자열이_숫자인_경우_예외_발생_X() {

        //given
        String input = "8000";

        //when, then
        assertThatNoException().isThrownBy(() -> isNum(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"ten", "1a", "a12"})
    void 입력문자열이_숫자가_아닌_경우_예외처리(String input) {
        assertThatThrownBy(() -> isNum(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 금액 값은 숫자여야 합니다.");
    }

    @Test
    void 입력한_금액이_1000원으로_나누어_떨어지지_않는_경우_예외처리() {

        //given
        int amount = 10500;

        //when, then
        assertThatThrownBy(() -> isDividedUp(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 1장의 가격은 1,000원입니다. 금액 값은 1,000원 단위로 입력해주세요.");
    }

    @Test
    void 입력한_금액이_1000원으로_나누어_떨어지는_경우_예외_발생_X() {

        //given
        int amount = 12000;

        //when, then
        assertThatNoException()
                .isThrownBy(() -> isDividedUp(amount));
    }

    @Test
    void 로또_발행_개수_확인() {

        //given
        int amount = 14000;

        //when
        int result = isDividedUp(amount);

        //then
        assertThat(result).isEqualTo(14);
    }
}