package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AmountTest extends Amount{

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
    void 입력한_금액이_1000원으로_나누어_떨어지는_경우_입력한_금액을_반환() {

        //given
        int amount = 12000;

        //when
        int result = isDividedUp(amount);

        //then
        assertThat(result).isEqualTo(12000);
    }
}