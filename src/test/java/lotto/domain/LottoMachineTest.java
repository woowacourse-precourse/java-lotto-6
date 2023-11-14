package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoMachineTest {

    @DisplayName("구입 금액에 맞게 로또를 생성하는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1000, 1", "2000, 2", "3000, 3", "4000, 4", "5000, 5", "53000, 53"})
    void lottoSizeTest(int purchaseAmount, int boughtLottoSize) {
        List<Lotto> lottos = LottoMachine.generateLottoByPurchaseAmount(purchaseAmount);
        assertThat(lottos.size()).isEqualTo(boughtLottoSize);
    }
}