package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerTest {
    @Test
    @DisplayName("숫자로만 이루어진 문자열이 아닐 경우 예외가 발생한다.")
    void occurNotMadeNumberException() {
        //given
        String buyPrice = "1000J";

        //when && then
        assertThatThrownBy(() -> Customer.create(buyPrice)).isInstanceOf(
            NumberFormatException.class)
            .hasMessage("숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("입력한 금액이 빈 문자열일 경우에 예외가 발생한다.")
    void occur1000LessThanException() {
        //given
        String buyPrice = "";

        //when && then
        assertThatThrownBy(() -> Customer.create(buyPrice)).isInstanceOf(
                NumberFormatException.class)
            .hasMessage("숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("입력한 금액이 공백일 경우에 예외가 발생한다.")
    void occur1000UnitException() {
        //given
        String buyPrice = " ";

        //when && then
        assertThatThrownBy(() -> Customer.create(buyPrice)).isInstanceOf(
                NumberFormatException.class)
            .hasMessage("숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("구입가격 10000원이면 로또 10개를 구입할 수 있다.")
    void buyLotto() {
        //given
        String buyPrice = "10000";

        //when
        Customer customer = Customer.create(buyPrice);

        //when
        assertThat(customer.getBuyCount()).isEqualTo(10);

    }

}