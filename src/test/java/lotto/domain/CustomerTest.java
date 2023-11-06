package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constants.SystemOption.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CustomerTest {

    int payment = 1000;
    int numOfLottos = payment / PAYMENT_UNIT_VALUE.getValue();
    Customer customer;

    @BeforeEach
    void setUp(){
        customer = Customer.createCustomer(payment);
    }


    @DisplayName("지불 금액만큼 수량의 로또 구매 성공")
    @Test
    void successBuyLotto() {

        assertDoesNotThrow(() -> customer.buyLottos());

        assertThat(customer.getCountOfLottos()).isEqualTo(numOfLottos);
    }

    @DisplayName("구매한 로또 개수만큼 로또 정보 반환 성공")
    @Test
    void successGetInfoOfLottos(){
        customer.buyLottos();

        List<String> info = assertDoesNotThrow(() -> customer.getInfoOfLottos());
        assertThat(info.size()).isEqualTo(numOfLottos);

    }



    @DisplayName("구매한 로또 개수만큼 Target 과 비교 후 Result 생성 성공")
    @Test
    void successCalculateResult(){
        customer.buyLottos();
        Target target = Target.createTarget(List.of(1, 2, 3, 4, 5, 6), 7);

        assertDoesNotThrow(() -> customer.calculateResult(target));
        assertThat(customer.getResults()).hasSize(numOfLottos);

    }

}