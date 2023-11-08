package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CustomerTest {
    static Customer customer;

    @BeforeEach
    void setup() {
        this.customer = new Customer(3000);
    }

    @DisplayName("customer에 로또를 추가하면 로또배열의 길이는 1이고, hasTicket도 1이다.")
    @Test
    void addCustomerLotto() {
        Lotto newLotto = new Lotto(List.of(1,2,3,4,5,6));
        customer.addCustomerLotto(newLotto);
        assertThatThrownBy(()->customer.getCustomerLotto(1)).isInstanceOf(IndexOutOfBoundsException.class);
        assertThat(customer.getHasTicket()).isEqualTo(1);
    }

    @DisplayName("지정된 값 만큼 wallet이 감소한다.")
    @Test
    void pay_TEST() {
        assertThat(customer.getWallet()).isEqualTo(3000);
        customer.pay(1000);
        assertThat(customer.getWallet()).isEqualTo(2000);
    }
}