package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    private Customer customer;
    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        customer = new Customer(1000);
        lottoMachine = new LottoMachine();
    }

    @DisplayName("발행받은 복권을 저장한다.")
    @Test
    public void issuedLottos() {
        // given
        Lotto issuedLotto = lottoMachine.issueLotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6));

        // when
        customer.buyLotto(issuedLotto);

        // then
        customer.getIssuedLottos().stream().forEach(lotto ->
                assertThat(lotto.getNumbers()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }
}
