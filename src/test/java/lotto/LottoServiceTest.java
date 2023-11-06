package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.service.LottoService;
import lotto.util.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoServiceTest {


    @DisplayName("LottoService는 구입 금액에 따라 로또 티켓을 생성한다")
    @ParameterizedTest
    @CsvSource({"1000,1", "2000,2", "5000,5", "10000,10"})
    void createTest(int purchaseAmount, int expectedLottoCount) {
        LottoService lottoService = new LottoService(new RandomNumberGenerator());
        List<Lotto> lottos = lottoService.generateWith(Money.from(purchaseAmount));

        assertThat(lottos.size()).isEqualTo(expectedLottoCount);
    }
}
