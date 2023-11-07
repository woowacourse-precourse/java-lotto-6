package lotto.domain.lotto;

import lotto.domain.customer.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoServiceTest {
    private Customer customer;
    private LottoService lottoService;

    private static final String PRICE = "5000";
    private static final int QUANTITY = 5;

    @BeforeEach
    void setUp() {
        customer = new Customer(PRICE);
        lottoService = new LottoService();
    }

    @DisplayName("Customer 인자로 받아서 로또 리스트 생성")
    @Test
    void createListWithCustomer() {
        assertThat(lottoService.drawLots(customer)).isInstanceOf(List.class);
    }

    @DisplayName("구입매수 만큼 로또 발행")
    @Test
    void drawLotsAsQuantityOfPurchase() {
        assertThat(lottoService.drawLots(customer).size()).isEqualTo(QUANTITY);
    }
}