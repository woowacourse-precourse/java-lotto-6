package lotto.service;

import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.Lucky;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {
    Customer customer = new Customer(5000);
    Lucky lucky = new Lucky(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
    LottoService lottoService = new LottoService(customer, lucky);

    @Test
    @DisplayName("손님이 로또를 산다.")
    void 로또_구매() {
        //given
        LottoService lottoService = new LottoService(customer, lucky);

        //when
        lottoService.buyLotto();
        List<Lotto> lottos = customer.getLottos();

        //then
        Assertions.assertThat(lottos.size()).isEqualTo(5);
    }

}