package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.enums.LottoConfig;
import lotto.service.LottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @DisplayName("구매 금액에 맞는 로또 개수를 발행한다.")
    @Test
    void createLottoByPayAmount() {
        // given
        int payAmount = 18000;

        // when
        List<Lotto> lottos = lottoService.publishLottos(payAmount);

        // then
        assertThat(lottos.size()).isEqualTo(payAmount / LottoConfig.LOTTO_AMOUNT.getValue());
    }
}
