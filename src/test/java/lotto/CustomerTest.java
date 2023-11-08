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
    @DisplayName("입력한 금액이 숫자로만 이루어져 있고 1000원 이상 및 1000원 단위일 경우 소비자는 구입가격 / 1000 만큼 로또를 구입한다.")
    void buyLotto() {
        //given
        String buyPrice = "10000";

        //when
        Customer customer = Customer.create(buyPrice);

        //when
        assertThat(customer.getBuyCount()).isEqualTo(10);

    }

}