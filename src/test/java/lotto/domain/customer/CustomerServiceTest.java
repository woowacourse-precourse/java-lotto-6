package lotto.domain.customer;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CustomerServiceTest {
    private static final String PRICE = "5000";

    private Customer customer;
    private CustomerService customerService;
    private LottoService lottoService;


    @BeforeEach
    void setUp() {
        customer = new Customer(PRICE);
        customerService = new CustomerService();
        lottoService = new LottoService();
    }

    @DisplayName("로또 리스트 입력 받아 customer 내 lottos에 값 주입")
    @Test
    void setLottosWithInput() {
        List<Lotto> lottos = lottoService.drawLots(customer);
        customerService.buyLotto(customer, lottos);
        assertThat(customer.getLottos()).isEqualTo(lottos);
    }
}