package lotto.lotto;

import java.util.List;
import lotto.generator.NumberGenerator;
import lotto.generator.RandomLottoNumberGenerator;
import lotto.money.LottoMoney;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        NumberGenerator generator = new RandomLottoNumberGenerator();
        lottoService = new LottoService(generator);
    }

    @DisplayName("입력 금액에 따른 로또를 생성한다.")
    @Test
    void makeLottos() {
        LottoMoney lottoMoney = new LottoMoney("6000");

        List<Lotto> lottos = lottoService.makeLottoPaper(lottoMoney);

        Assertions.assertThat(lottos).hasSize(6);
    }
}
