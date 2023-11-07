package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    @DisplayName("손님이 돈을 내면 로또를 발급받는다.")
    void 로또_발급(){
        //given
        Customer customer=new Customer("10000");

        //when
        customer.pay();
        List<Lotto>  lottos=customer.getLottos();

        //then
        Assertions.assertThat(lottos.size()).isEqualTo(10);
    }

}