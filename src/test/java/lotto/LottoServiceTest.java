package lotto;


import java.util.List;
import lotto.controller.service.LottoService;
import lotto.model.Lotto;
import lotto.model.LottoMoney;
import lotto.utils.NumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoServiceTest {

    @ParameterizedTest
    @CsvSource(
            {
                    "10000, 10",
                    "20000, 20",
                    "15000, 15",
                    "100000, 100",
                    "99000, 99",
            }
    )
    @DisplayName("돈 지불하여 로또를 구입할 개수를 받는다.")
    void countLottoTest(int money, int count) {
        LottoMoney lottoMoney = new LottoMoney(money);
        int quantity = lottoMoney.calculateCountLottoPrice();
        Assertions.assertThat(quantity).isEqualTo(count);
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "10000, 10",
                    "20000, 20",
                    "15000, 15",
                    "100000, 100",
                    "99000, 99",
            }
    )
    @DisplayName("돈을 지불하여 로또번호를 받는다.")
    void purchaseLottoTest(int money, int count) {
        LottoService lottoService = new LottoService(new NumberGenerator());
        LottoMoney lottoMoney = new LottoMoney(money);
        List<Lotto> lottos = lottoService.createLottoNumbers(lottoMoney);
        Assertions.assertThat(lottos.size()).isEqualTo(count);
    }
}