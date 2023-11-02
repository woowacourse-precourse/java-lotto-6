package lotto.service;

import lotto.domain.Lotto;
import lotto.utils.NumberGenerator;
import lotto.utils.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoServiceTest {

    @DisplayName("로또 구매 수량 검증 테스트")
    @Test
    void buyLottoTest() {
        LottoService lottoService = new LottoService();
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        int lottoQuantity = 3;

        List<Lotto> lottos = lottoService.buyLottos(randomNumberGenerator, lottoQuantity);

        assertThat(lottos.size()).isEqualTo(lottoQuantity);
    }

}