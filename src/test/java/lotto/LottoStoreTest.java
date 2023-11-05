package lotto;


import java.util.List;
import lotto.model.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;;

class LottoStoreTest {

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
        LottoStore lottoStore = new LottoStore(new NumberGenerator());
        int quantity = lottoStore.calculateLottoNumberByMoney(money);
        Assertions.assertThat(quantity).isEqualTo(count);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 2, 3, 4, 6, 7, 8, 9, 10})
    @DisplayName("수량을 입력하여 로또를 생성한다.")
    void createLottoTest(int quantity) {
        LottoStore lottoStore = new LottoStore(new NumberGenerator());
        List<Lotto> lottoNumbers = lottoStore.createLottoNumbers(quantity);
        Assertions.assertThat(lottoNumbers.size()).isEqualTo(quantity);
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
        LottoStore lottoStore = new LottoStore(new NumberGenerator());
        List<Lotto> lottos = lottoStore.purchaseLottoNumbers(money);
        Assertions.assertThat(lottos.size()).isEqualTo(count);
    }
}