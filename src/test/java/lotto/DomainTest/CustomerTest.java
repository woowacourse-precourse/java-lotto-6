package lotto.DomainTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.Domain.Customer;
import lotto.Domain.LottoStore;
import lotto.Domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CustomerTest {
    private final String LOTTO_PURCHASE_AMOUNT = "3000";
    private Customer customer;
    private LottoStore lottoStore;

    @BeforeEach
    void init(){
        customer = new Customer();
        lottoStore = new LottoStore();
    }

    @DisplayName("(예외처리)구매금액 잘못 입력한 경우")
    @ParameterizedTest
    @ValueSource(strings={"3500","900","50"})
    void buyLottoTest(String lottoPurchaseAmount){
        assertThatThrownBy(() -> customer.buyLotto(lottoStore, lottoPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액은 1000으로 나누어 떨어져야 합니다.");
    }


}
